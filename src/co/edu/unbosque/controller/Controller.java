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
		 tc.setListaCompras(tc.getRc().ReadFromPath("csv/data.csv")); 
		while (v.getMenu()!=0) {
			int nMenu = v.showmenu();
			v.setMenu(nMenu);
			switch(v.getMenu()) {
			case 1: v.mostrarMensaje("This is the total  sales of the store : " + tc.sumTotalSales());	
			break;
			case 2: v.mostrarMensaje("The detail of a requested invoice is : " + tc.findByInvoiceNo(v.leerDato("Please enter de invoice of the sale:")));
			break;
			case 3: v.mostrarMensaje(tc.countByStockCode(v.leerDato("Please enter the stock code of the product:"))); 
			break;
			case 4: System.out.println(tc.avgMonthSales(true));
			break;
			case 5: String dato = v.leerDato("Please enter the word that you want to search: ");
				System.out.println((tc.searchForDescription( dato, true, 2, 12)));

				break;
			case 0: 
				v.mostrarMensaje("Thanks for your atention, bye :) !!!");
				break;
			default: v.mostrarMensaje("The number is not valid.");
			break;
			}
		}

	}
}