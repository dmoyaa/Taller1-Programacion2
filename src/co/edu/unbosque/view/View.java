package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	public String leerDato(String mensaje) {
		String respuesta="";
		respuesta= JOptionPane.showInputDialog(mensaje);
		return respuesta;
	}
	
}
