package es.uniovi.asw.ConfParser;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import es.uniovi.asw.ConfParser.Parser.conf.ParserConf;
import es.uniovi.asw.ConfParser.Parser.options.ParserOpt;
import es.uniovi.asw.ConfParser.Parser.places.ParserPlaces;
import es.uniovi.asw.ConfParser.factoria.FactoriaParserConf;
import es.uniovi.asw.ConfParser.factoria.FactoriaParserOption;
import es.uniovi.asw.ConfParser.factoria.FactoriaParserPlaces;
import es.uniovi.asw.DBVote.Jpa;
import es.uniovi.asw.DBVote.impl.InsertConfP;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadConfiguration {
	
	static Map<String, ParserOpt> factoriaOptions = new HashMap<>();
	static Map<String, ParserPlaces> factoriaPlaces = new HashMap<>();
	static Map<String, ParserConf> factoriaConf = new HashMap<>();
	
	 static List<String> opcionesFicherosEntrada = new LinkedList<String>();

	 ROptions rOptions = null;
	 RConf rConf = null;
	 RPlaces rPlaces = null;
	 
	public static void main(String... args) {
		
		cargarFactorias();
		cargarOpciones();
		LoadConfiguration runner = new LoadConfiguration();
		runner.run(args);

	}

	void run(String... args) {		
		Options options = new Options();
		options.addOption("x", false, "add xls file");
		options.addOption("h", false, "help");
		
		CommandLineParser cLParser = new DefaultParser();
		CommandLine cmd = null;
		
		try {
			
			cmd = cLParser.parse(options, args);

			if(!cmd.hasOption("h")){
			
			//Se comprueba si se inserto una opción para el fichero de entrada
			if(opcionFicheroEntrada(cmd)) {
				
				ParserConf parserConf = null;
				ParserPlaces parserPlaces = null;
				ParserOpt parserOpt = null;
					
//				//Obtiene parser de ficheros de entrada especificado en las opciones				
				String option = cmd.getOptions()[0].getOpt();
				if (opcionesFicherosEntrada.contains(option)) {
					parserConf = factoriaConf.get(option);
				}
				
				option = cmd.getOptions()[1].getOpt();
				if (opcionesFicherosEntrada.contains(option)) {
					parserOpt = factoriaOptions.get(option);
				}
				
				option = cmd.getOptions()[2].getOpt();
				if (opcionesFicherosEntrada.contains(option)) {
					parserPlaces = factoriaPlaces.get(option);
				}
				
				
				//Funciona de momento para este en concreto
				//java -jar AdminSystem/target/adminSystem-0.0.1.jar AdminSystem/conf.xls -x AdminSystem/options.xls -x AdminSystem/places.xls -x

				rConf = new RConf(args[0], parserConf);
				rOptions = new ROptions(args[2], parserOpt);
				rPlaces = new RPlaces(args[4], parserPlaces);
			}			
			
			else {
			    System.out.println("Opciones no válidas, puedes utilizar"
			    		+ " la opción -h para apreder a utilizar el programa");
			}

				if (rOptions != null && rConf != null && rPlaces != null) {

					rOptions.leerDatos();
					rConf.leerDatos();
					rPlaces.leerDatos();
					try {
						InsertConfP.insertConfR();
					} catch (Exception e) {
						System.out.println("Uno de los ficheros esta mal configurado, por lo que los datos no han sido guardados");
					}
				}

//			System.out.println("Error en la hora de inicio o fin");
			
			}else{
				
				System.out.println("------------------------------------------"
						+ "----------------------------");
				
				System.out.println("Ayuda para programa AdminSystem:");
				System.out.println("Para utilizar el programa debe de "
						+ "especificar el formato de los ficheros de entrada ");
				
				System.out.println();
				
				System.out.println("Los formatos de ficheros de entrada "
						+ "permitidos son:");
				
				System.out.println("  -x -> Archivos excel (Formato xls)");
				
				
				System.out.println("Ejemplo: ");
				
				System.out.println("Datos leidos de xls:");

				System.out.println("java -jar AdminSystem/target/adminSystem-0.0.1.jar "
						+ "AdminSystem/conf.xls -x "
						+ "AdminSystem/options.xls -x "
						+ "AdminSystem/places.xls -x");

				System.out.println("------------------------------------------"
						+ "----------------------------");
				
			}
			
		
					
		} catch (ParseException e) {
//			e.printStackTrace();
		}
		Jpa.closeEntityManagerFactory();
	
	}
	
	
	private static void cargarFactorias() {
		
		//Factorias parsers
		factoriaOptions.put("x", FactoriaParserOption.crearParserXLS());
		
		factoriaConf.put("x",FactoriaParserConf.crearParserXLS());
		
		factoriaPlaces.put("x", FactoriaParserPlaces.crearParserXLS());
		
	}
	

	/**
	 * Guarda en colecciones las opciones disponibles
	 * 
	 */
	private static void cargarOpciones() {
		//Opciones de ficheros entrada
		opcionesFicherosEntrada.add("x");
		
	}

	/**
	 * Comprueba si alguna de las opciones es para describir el 
	 * fichero de entrada
	 * @param cmd
	 * @return
	 */
	public boolean opcionFicheroEntrada(CommandLine cmd){
		
		for(Option option: cmd.getOptions()){
			if(opcionesFicherosEntrada.contains(option.getOpt())){
				return true;
			}
		}		
		
		return false;
		
		
	}
	

	
	
}
