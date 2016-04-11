package es.uniovi.asw.ConfParser;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import es.uniovi.asw.ConfParser.Parser.conf.ParserConf;
import es.uniovi.asw.ConfParser.Parser.conf.impl.ParserConfXLS;
import es.uniovi.asw.ConfParser.Parser.options.ParserOpt;
import es.uniovi.asw.ConfParser.Parser.options.impl.ParserOptXLS;
import es.uniovi.asw.ConfParser.Parser.places.ParserPlaces;
import es.uniovi.asw.ConfParser.Parser.places.impl.ParserPlacesXLS;
import es.uniovi.asw.DBVote.Jpa;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadConfiguration {

//	 static Map<String,FactoriaOptions> factoriasFicheroEntrada = new HashMap<String,FactoriaOptions>();
	 
	 static List<String> opcionesFicherosEntrada = new LinkedList<String>();

	 //Esto se añade en votingSystem
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
					
				//Obtiene parser de ficheros de entrada especificado en las opciones
				for(Option opt: cmd.getOptions()){
					if(opcionesFicherosEntrada.contains(opt.getOpt())){
//						parserConf = factoriasFicheroEntrada.get(opt.getOpt()).crearParser();
					}
				}
				
				//Funciona de momento para este en concreto
				//java -jar AdminSystem/target/adminSystem-0.0.1.jar AdminSystem/options.xls -x AdminSystem/conf.xls -x AdminSystem/places.xls -x 

				
				//Esto es para probar, queda por hacer cosas
				rOptions = new ROptions(args[0], new ParserOptXLS());
				rConf = new RConf(args[2], new ParserConfXLS());
				rPlaces = new RPlaces(args[4], new ParserPlacesXLS());
			}			
			
			else {
			    System.out.println("Opciones no válidas, puedes utilizar"
			    		+ " la opción -h para apreder a utilizar el programa");
			}
			
			
			if(rOptions!= null){
				rOptions.leerDatos();
			}
			if(rConf != null){
				rConf.leerDatos();
			}
			if(rPlaces != null){
				rPlaces.leerDatos();
			}
			
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

				System.out.println("  java -jar target/adminSystem-0.0.1.jar "
						+ "lugares.xls opcionesVoto.xls configuracion.xls -x");
				
				
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
//		factoriasFicheroEntrada.put("x", new ParserXLSFactory());
		
		
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
