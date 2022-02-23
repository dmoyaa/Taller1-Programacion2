package co.edu.unbosque.model.csv;

import com.opencsv.CSVReader;
import com.opencsv.bean.*;

import co.edu.unbosque.model.Compra;
import co.edu.unbosque.model.TransferCsvToCompra;

import java.io.FileReader;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {

	/*
	 * Método que accede al archivo csv y lee su contenido
	 */
	
	public ArrayList<Compra> ReadFromPath(String localpath){

		TransferCsvToCompra tc = new TransferCsvToCompra();

		try {
		
			CSVReader reader = new CSVReader(new FileReader(localpath));
			String[]nextline = null; 
			nextline=reader.readNext();
			do {
				nextline=reader.readNext();
				
				try {
				String IN=nextline[0]; 
				String SC= nextline[1];
				String Des= nextline[2] ;
				int Qua = Integer.parseInt(nextline[3])  ;
				String ID = nextline[4]; 
				double UP = Double.parseDouble(nextline[5]);
				String CI = nextline[6];
				String Cou = nextline[7];
				Compra c = new Compra(IN, SC , Des, Qua, ID, UP, CI, Cou);
				tc.addSales(c);
				}catch(Exception e) {
				}
			} while((nextline != null));

			reader.close();
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("No leí");
		}
		System.out.println("leí exitosamente");		
		return tc.getListaCompras();

	}



}
