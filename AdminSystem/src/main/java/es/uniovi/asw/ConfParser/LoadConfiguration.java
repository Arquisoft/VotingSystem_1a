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
import es.uniovi.asw.ConfParser.impl.RConf;
import es.uniovi.asw.ConfParser.impl.ROptions;
import es.uniovi.asw.ConfParser.impl.RPlaces;
import es.uniovi.asw.DBVote.Jpa;
import es.uniovi.asw.DBVote.impl.InsertConfP;
import es.uniovi.asw.DBVote.impl.InsertVoteP;
import es.uniovi.asw.countVoteParser.RVotes;
import es.uniovi.asw.countVoteParser.factoria.FactoriaParserVotes;
import es.uniovi.asw.countVoteParser.parser.ParserVotes;
import es.uniovi.asw.util.AdminException;

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
	static Map<String, ParserVotes> factoriaVotes = new HashMap<>();

	static List<String> opcionesFicherosEntrada = new LinkedList<String>();

	es.uniovi.asw.ConfParser.Options rOptions = null;
	Conf rConf = null;
	Places rPlaces = null;

	RVotes rVote = null;

	public static void main(String... args) throws AdminException {

		cargarFactorias();
		cargarOpciones();
		LoadConfiguration runner = new LoadConfiguration();
		runner.run(args);

	}

	void run(String... args) throws AdminException {
		Options options = new Options();
		options.addOption("conf", false, "configuration");
		options.addOption("count", false, "configuration");
		options.addOption("x", false, "add xls file");
		options.addOption("h", false, "help");

		CommandLineParser cLParser = new DefaultParser();
		CommandLine cmd = null;

		try {

			cmd = cLParser.parse(options, args);

			if (!cmd.hasOption("h")) {

				if (args.length != 0) {
					String sistema = args[0];

					if (sistema.equals("conf")) {
						runConfigSystem(cmd, args);
					} else if (sistema.equals("count")) {
						runCountVotesSystem(cmd, args);
					} else {
						System.out.println("Opciones no válidas, puedes utilizar"
								+ " la opción -h para apreder a utilizar el programa");
					}
				} else {
					System.out.println("Opciones no válidas, puedes utilizar"
							+ " la opción -h para apreder a utilizar el programa");
				}
			} else {

				ayudaConfSystem();
				ayudaCountVotes();

			}

		} catch (ParseException e) {
			// e.printStackTrace();
		}

	}

	/**
	 * Ejecuta toda la logica necesaria del systema de configuracion
	 * 
	 * @param cmd
	 * @param args
	 * @throws AdminException
	 */
	private void runConfigSystem(CommandLine cmd, String... args) throws AdminException {
		ParserConf parserConf = null;
		ParserPlaces parserPlaces = null;
		ParserOpt parserOpt = null;

		// //Obtiene parser de ficheros de entrada especificado en las opciones
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

		// Funciona de momento para este en concreto
		// java -jar AdminSystem/target/adminSystem-0.0.1.jar conf
		// AdminSystem/conf.xls -x AdminSystem/options.xls -x
		// AdminSystem/places.xls -x

		rConf = new RConf(args[1], parserConf);
		rOptions = new ROptions(args[3], parserOpt);
		rPlaces = new RPlaces(args[5], parserPlaces);

		if (rOptions != null && rConf != null && rPlaces != null) {

			rOptions.leerDatos();
			rConf.leerDatos();
			rPlaces.leerDatos();
			try {
				new InsertConfP().insertConfR();
			} catch (AdminException e) {
				e.printStackTrace();
			}
		}

		Jpa.closeEntityManagerFactory();
	}

	/**
	 * Ejecuta la logica necesario del sistema de recuento de votos
	 * 
	 * @param cmd
	 * @param args
	 * @throws AdminException
	 */
	private void runCountVotesSystem(CommandLine cmd, String... args) throws AdminException {
		ParserVotes parser = null;

		// //Obtiene parser de ficheros de entrada especificado en las opciones
		String option = cmd.getOptions()[0].getOpt();
		if (opcionesFicherosEntrada.contains(option)) {
			parser = factoriaVotes.get(option);
		}

		// Funciona de momento para este en concreto
		// java -jar AdminSystem/target/adminSystem-0.0.1.jar count
		// AdminSystem/votes.xls -x

		rVote = new RVotes(args[1], parser);

		if (rVote != null) {
			rVote.leerDatos();
			try {
				new InsertVoteP().insertVoteR();
			} catch (AdminException e) {
				e.printStackTrace();
			}
		}

		Jpa.closeEntityManagerFactory();

	}

	/**
	 * Muestra la ayuda del sistema de configuracion
	 */
	private void ayudaConfSystem() {
		System.out.println("------------------------------------------" + "----------------------------");

		System.out.println("Ayuda para configuracion del sistema:");
		System.out.println("Para utilizar el programa debe de " + "especificar el formato de los ficheros de entrada ");

		System.out.println();

		System.out.println("Los formatos de ficheros de entrada " + "permitidos son:");

		System.out.println("  -x -> Archivos excel (Formato xls)");

		System.out.println("Ejemplo: ");

		System.out.println("Datos leidos de xls:");

		System.out.println("java -jar AdminSystem/target/adminSystem-0.0.1.jar " + "conf " + "AdminSystem/conf.xls -x "
				+ "AdminSystem/options.xls -x " + "AdminSystem/places.xls -x");

		System.out.println("------------------------------------------" + "----------------------------");
	}

	/**
	 * Muestra la ayuda del sistema de recuento de votos
	 */
	private void ayudaCountVotes() {
		System.out.println("------------------------------------------" + "----------------------------");

		System.out.println("Ayuda para recuento de votos:");
		System.out.println("Para utilizar el programa debe de " + "especificar el formato de los ficheros de entrada ");

		System.out.println();

		System.out.println("Los formatos de ficheros de entrada " + "permitidos son:");

		System.out.println("  -x -> Archivos excel (Formato xls)");

		System.out.println("Ejemplo: ");

		System.out.println("Datos leidos de xls:");

		System.out.println(
				"java -jar AdminSystem/target/adminSystem-0.0.1.jar " + "count " + "AdminSystem/votes.xls -x ");

		System.out.println("------------------------------------------" + "----------------------------");
	}

	/**
	 * Carga las factorias con los diferentes tipos de passwords en funcion de
	 * la opcion
	 */
	private static void cargarFactorias() {

		// Factorias parsers
		factoriaOptions.put("x", FactoriaParserOption.crearParserXLS());

		factoriaConf.put("x", FactoriaParserConf.crearParserXLS());

		factoriaPlaces.put("x", FactoriaParserPlaces.crearParserXLS());

		factoriaVotes.put("x", FactoriaParserVotes.crearParserXLS());

	}

	/**
	 * Guarda en colecciones las opciones disponibles
	 * 
	 */
	private static void cargarOpciones() {
		// Opciones de ficheros entrada
		opcionesFicherosEntrada.add("x");

	}

	/**
	 * Comprueba si alguna de las opciones es para describir el fichero de
	 * entrada
	 * 
	 * @param cmd
	 * @return
	 */
	public boolean opcionFicheroEntrada(CommandLine cmd) {

		for (Option option : cmd.getOptions()) {
			if (opcionesFicherosEntrada.contains(option.getOpt())) {
				return true;
			}
		}

		return false;

	}

}
