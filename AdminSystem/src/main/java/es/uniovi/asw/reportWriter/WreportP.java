package es.uniovi.asw.reportWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class WreportP implements WriteReport {

	File file = new File("log.txt");
	
	public void log(String datos) {
		
		try {				
			
			FileWriter fW = new FileWriter(file, true);
			fW.write(new Date()+" - "+datos+"\n");
			fW.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}


}
