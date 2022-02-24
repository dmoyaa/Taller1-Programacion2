package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {
	
	private int menu;
	
	/*
	 * Método constructor
	 */
	
	public View() {
		menu = -1;
	}
	
	/*
	 * Método que muestra por JOption los mensajes que hayamos puesto
	 */
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	/*
	 * Método que pide un dato tipo String
	 */
	
	public String leerDato(String mensaje) {
		String respuesta="";
		respuesta= JOptionPane.showInputDialog(mensaje);
		return respuesta;
	}
	
	/*
	 * Método de opciones de la tienda
	 */
	
	public int showmenu() {
		
		int respuesta = 0;
		
		String mensaje=JOptionPane.showInputDialog("Ingrese lo que quiere hacer:"
				+"\n 1. Calcular el total de ventas de la tienda."
				+"\n 2. Retornar el detalle de una factura solicitada."
				+"\n 3. Contar la cantidad de unidades vendidas para un stock solicitado."
				+"\n 4. Retornar el promedio de ventas mensuales con la opción de agrupar por país."
				+"\n 5. Retornar la lista de descripciones que coinciden parcialmente con el criterio"
				+ " de búsqueda incluyendo la cantidad de unidades vendidas , ordenadas de menor a mayor. "
				+"\n 0. Salir.");
		
		respuesta=Integer.parseInt(mensaje);
		return respuesta;
		
	}

	public int getMenu() {
		return menu;
	}

	public void setMenu(int menu) {
		this.menu = menu;
	}
	
	
	
}