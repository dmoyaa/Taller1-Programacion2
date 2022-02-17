package co.edu.unbosque.model;

import java.text.SimpleDateFormat;
import java.util.*;

import co.edu.unbosque.model.csv.ReadCSV;

public class TransferCsvToCompra {

    private ArrayList<Compra> listaCompras = new ArrayList<>();
    private final ReadCSV rc;

    public TransferCsvToCompra() {
        rc = new ReadCSV();
    }


    // punto 2

    public double totalVentas() {
        double total = 0.0;
        for (Compra compra : listaCompras) {
            double aux = compra.getQuantity() * compra.getUnitPrice();
            total += aux; // total = total + aux;
        }
        return total;
    }

    public ArrayList<Compra> buscarPorDescripcion(String search, boolean order, int initMonth, int endMonth) {
        ArrayList<Compra> comprasEncontradas = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = new GregorianCalendar();

        try {
            for (Compra compra : listaCompras) {
                String descripcionActual = compra.getDescription();
                Date date = simpleDateFormat.parse(compra.getInvoiceDate());
                calendar.setTime(date);
                int mes = calendar.get(Calendar.MONTH);

                if (descripcionActual.contains(search)) {
                    if (mes >= initMonth && mes <= endMonth) {
                        comprasEncontradas.add(compra);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return comprasEncontradas;
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

    public ArrayList<Compra> agregarCompra(Compra c) {
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
