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

    public double sumTotalSales() {
        double total = 0.0;
        for (Compra compra : listaCompras) {
            double aux = compra.getQuantity() * compra.getUnitPrice();
            total += aux; // total = total + aux;
        }
        return total;
    }
    
    public String countByStockCode (String StockCode) {
    	String respuesta = "The StockCode does not exist in the shopping list.";
    	int unidades = 0;
        listaCompras = rc.ReadFromPath("csv/data.csv");
    	for (int i = 0; i < listaCompras.size(); i++) {
    		
    		if(listaCompras.get(i).getStockCode().equals(StockCode)) {
    			unidades += listaCompras.get(i).getQuantity();
    			respuesta = "The product '"+listaCompras.get(i).getDescription()+"' has been sold: "
    					+ unidades + " times.";
    		}   		
		}
    	
    	return respuesta;
    }

    public ArrayList<Compra> searchForDescription(String search, boolean order, int initMonth, int endMonth) {
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

//    public String mostrarresultados() {
//        String respuesta = "";
//        listaCompras = rc.ReadFromPath("csv/data.csv");
//        respuesta = listaCompras.get(1).toString();
//        return respuesta;
//    }

    public ArrayList<Compra> addSales(Compra c) {
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
