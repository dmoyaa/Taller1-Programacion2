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

	public ArrayList<Compra> ReadFromPath(String localpath){

		TransferCsvToCompra tc = new TransferCsvToCompra();

		try {
			//			URI uri = ClassLoader.getSystemResource(localpath).toURI();
			//			Path path = Paths.get(uri);
			//			HeaderNameBaseMappingStrategy ms = new HeaderColumnNameMappingStrategy();
			//			ms.setType(Compra.class);
			//			System.out.println("estoy leyendo");
			//
			//
			//			Reader reader = Files.newBufferedReader(path);
			//			CsvToBean cb = new CsvToBeanBuilder(reader).withType(Compra.class)
			//					.withMappingStrategy(ms).withSeparator(';').build();
			//
			//			TransferCsvToCompra tc = new TransferCsvToCompra();
			//			tc.setCsvlist(cb.parse());
			//			reader.close();
			//
			//			return tc.getCsvlist();

			CSVReader reader = new CSVReader(new FileReader(localpath));
			String[]nextline = null; 
//			while ((nextline=reader.readNext()) != null) {
			nextline=reader.readNext();
			do {
				nextline=reader.readNext();
				
//				System.out.println(nextline[0]);
//				System.out.println(nextline[1]);
//				System.out.println(nextline[2]);
//				System.out.println(nextline[3]);
//				System.out.println(nextline[4]);
//				System.out.println(nextline[5]);
//				System.out.println(nextline[6]);
//				System.out.println(nextline[7]);
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
				tc.agregarCompra(c);
				}catch(Exception e) {
				}
			} while((nextline != null));


//					for (int i = 0; i < nextline.length; i++) {
//						System.out.println(nextline[i]);
//					}
				
//		}
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
