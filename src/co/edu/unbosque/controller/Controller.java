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
		
		while (v.getMenu()!=0) {
			int nMenu = v.showmenu();
			v.setMenu(nMenu);
			switch(v.getMenu()) {
			case 1: v.mostrarMensaje("This is the total  sales of the store : " + tc.sumTotalSales());	
				break;
			case 2: v.mostrarMensaje("The detail of a requested invoice is : " + tc.findByInvoiceNo(v.leerDato("")));
				break;
			case 3: v.mostrarMensaje(tc.countByStockCode(v.leerDato("Please enter the stock code of the product:"))); 
				break;
			case 4: System.out.println(tc.avgMonthSales(true));
				break;
			case 5: //punto6
				break;
			case 0: 
				v.mostrarMensaje("Gracias por su atención. ¡Adios!");
				break;
			default: v.mostrarMensaje("The number is not valid.");
			break;
			}
		}
		
	}
//	public void funcionar() {
//		ventasdiarias();
//		while (vista.getSelect()!=0) {
//			int numeroMenu=vista.leerdatomenu();
//			vista.setSelect(numeroMenu);
//			switch (vista.getSelect()){
//			case 1:ingresosmesaño();
//			break;
//			case 2:sumadegananciasmes();
//			break;
//			case 3:promediosemanal();
//			break;
//			case 4:maximovendido(); 
//			break;
//			case 5:minimovendido();
//			break;
//			case 6:ventadiariamayor();
//			break;
//			case 7:menorgananciadiaria();
//			break;
//			case 8:ventaspromediomensual();
//			break;
//			case 0:
//				vista.mostrarmensaje("Gracias por su atención. ¡Adios!");
//				break;
//			default:
//				vista.mostrarmensaje("El número no es valido.");
//				break;
//			}
//		}
	}
	


