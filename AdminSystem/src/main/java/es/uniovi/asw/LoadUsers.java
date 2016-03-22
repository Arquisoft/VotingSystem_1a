package es.uniovi.asw;

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

import es.uniovi.asw.dbUpdate.Jpa;
import es.uniovi.asw.factorias.CartasFactory;
import es.uniovi.asw.factorias.CartasPDFFactory;
import es.uniovi.asw.factorias.CartasTXTFactory;
import es.uniovi.asw.factorias.ParserFactory;
import es.uniovi.asw.factorias.ParserXLSFactory;
import es.uniovi.asw.parser.GeneradorCartas;
import es.uniovi.asw.parser.Parser;
import es.uniovi.asw.parser.RCensus;
import es.uniovi.asw.parser.ReadCensus;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {
	
	 ReadCensus readCensus = null;
	 
	 static Map<String,CartasFactory> factoriasCartas = new HashMap<String,CartasFactory>();
	 static Map<String,ParserFactory> factoriasFicheroEntrada = new HashMap<String,ParserFactory>();
	 
	 static List<String> opcionesCartasSalida = new LinkedList<String>();
	 static List<String> opcionesFicherosEntrada = new LinkedList<String>();


	public static void main(String... args) {
		
		cargarFactorias();
		cargarOpciones();
		LoadUsers runner = new LoadUsers();
		runner.run(args);

	}

	void run(String... args) {		
		Options options = new Options();
		options.addOption("x", false, "add xls file");
		options.addOption("p", false, "generates pdf files");
		options.addOption("t", false, "generates txt files");
		options.addOption("h", false, "help");
		
		CommandLineParser cLParser = new DefaultParser();
		CommandLine cmd = null;
		
		try {
			
			cmd = cLParser.parse(options, args);

			if(!cmd.hasOption("h")){
			
			//Se comprueba si se inserto una opción para el fichero de entrada
			//y otra para el de salida
			if(opcionFicheroEntrada(cmd) && opcionCartas(cmd)) {
				
				GeneradorCartas generador = null;
				Parser parser = null;
					
				//Obtiene parser de ficheros de entrada especificado en las opciones
				for(Option opt: cmd.getOptions())	
					if(opcionesFicherosEntrada.contains(opt.getOpt()))
						parser = factoriasFicheroEntrada.get(opt.getOpt()).crearParser();
								
				
				//Obtiene generador de cartas especificado en las opciones
				for(Option opt: cmd.getOptions())	
					if(opcionesCartasSalida.contains(opt.getOpt()))
						generador = factoriasCartas.get(opt.getOpt()).crearGeneradorCartas();
				
				
				readCensus = new RCensus(args[0],generador,parser);

			}			
			
			else {
			    System.out.println("Opciones no válidas, puedes utilizar"
			    		+ " la opción -h para apreder a utilizar el programa");
			}
			
			
			if(readCensus!=null)
				readCensus.readCensus(); 
			
			
			}else{
				
				System.out.println("------------------------------------------"
						+ "----------------------------");
				
				System.out.println("Ayuda para programa Censuses:");
				System.out.println("Para utilizar el programa debe de "
						+ "especificar el formato de los ficheros de entrada "
						+ "y el formato de las cartas generadas.");
				
				System.out.println();
				
				System.out.println("Los formatos de ficheros de entrada "
						+ "permitidos son:");
				
				System.out.println("  -x -> Archivos excel (Formato xls)");
				
				
				System.out.println("Los formatos de ficheros de salida "
						+ "permitidos son:");
				
				System.out.println("  -t -> Archivo txt");
				System.out.println("  -p -> Archivo pdf");
				
				System.out.println();
				
				System.out.println("Ejemplo: ");
				
				System.out.println("Generar cartas en formato pdf obteniendo "
						+ "los datos de xls:");

				System.out.println("  java -jar target/censuses1a-0.0.1.jar "
						+ "Censos.xls -x -p");
				
				
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
		factoriasFicheroEntrada.put("x", new ParserXLSFactory());
		
		//Factorias generadores cartas
		factoriasCartas.put("t",new CartasTXTFactory());
		factoriasCartas.put("p",new CartasPDFFactory());
		
	}
	

	/**
	 * Guarda en colecciones las opciones disponibles
	 * 
	 */
	private static void cargarOpciones() {
		//Opciones de ficheros entrada
		opcionesFicherosEntrada.add("x");
		
		
		//Opciones de ficheros salida
		opcionesCartasSalida.add("p");
		opcionesCartasSalida.add("t");
		
		
		
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
	
	/**
	 * Comprueba si alguna de las opciones es para describir el 
	 * formato de las cartas
	 * @param cmd
	 * @return
	 */
	public boolean opcionCartas(CommandLine cmd){
		
		for(Option option: cmd.getOptions()){
			if(opcionesCartasSalida.contains(option.getOpt())){
				return true;
			}
		}		
		
		return false;
		
		
	}
	
	
}
