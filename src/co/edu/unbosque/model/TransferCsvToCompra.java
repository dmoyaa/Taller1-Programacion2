package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.model.csv.ReadCSV;

public class TransferCsvToCompra {

	ArrayList <Compra> listaCompras = new ArrayList<>();
	private ReadCSV rc;

	public TransferCsvToCompra() {
		rc = new ReadCSV();
	}

	public String mostrarresultados() {
		String respuesta = "";
		listaCompras = rc.ReadFromPath("csv/data.csv");
		respuesta = listaCompras.get(541908).toString();
//		for (int i = 0; i < listaCompras.size(); i++) {
//			respuesta= listaCompras.get(1).toString();
//		}
		return respuesta;
	}
	
	public ArrayList <Compra> agregarCompra(Compra c) {
		listaCompras.add(c);
		return listaCompras;
		
	}

	public ArrayList<Compra> getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(ArrayList<Compra> listaCompras) {
		this.listaCompras = listaCompras;
	}

	

//	public List<Compra> getCsvlist() {
//		if (csvlist != null) return csvlist;
//		return new ArrayList<>();
//	}
//
//	public void setCsvlist(List<Compra> csvlist) {
//		this.csvlist = csvlist;
//	}



}
