package co.edu.unbosque.controller;

import co.edu.unbosque.model.TransferCsvToCompra;
import co.edu.unbosque.view.View;

public class Controller {
	
	private TransferCsvToCompra tc;
	private View v;
	
	public Controller() {
		
		tc = new TransferCsvToCompra();
		v = new View();
		funcionar();
	}
	
	public void funcionar() {
		v.mostrarMensaje(tc.countByStockCode(v.leerDato("Please enter the stock code of the product:"))); 
	}
	

}
