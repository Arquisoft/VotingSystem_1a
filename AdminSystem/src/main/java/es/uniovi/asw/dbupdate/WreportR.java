package es.uniovi.asw.dbupdate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import es.uniovi.asw.reportwriter.WriteReport;

public class WreportR implements WriteReport {

	File file = new File("log.txt");

	@Override
	public void log(String datos) {
		try {

			FileWriter fW = new FileWriter(file, true);
			fW.write(new Date() + " - " + datos + "\n");
			fW.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
