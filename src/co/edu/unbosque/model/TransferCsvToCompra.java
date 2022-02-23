package co.edu.unbosque.model;

import java.text.SimpleDateFormat;
import java.util.*;

import co.edu.unbosque.model.csv.ReadCSV;

public class TransferCsvToCompra {

    private ArrayList<Compra> listaCompras = new ArrayList<>();
    private ReadCSV rc;

    public TransferCsvToCompra() {
    	rc = new ReadCSV();
    }

    /*
     * Recorre la lista, obtiene la cantidad y el precio por unidad
     * @return Total ventas
     */

    public double sumTotalSales() {
    	rc.ReadFromPath("csv/data.csv");
        double total = 0.0;
        for (Compra compra : listaCompras) {
            double aux = compra.getQuantity() * compra.getUnitPrice();
            total += aux;
        }
        return total;
    }
    
    /*
     * Recorre la lista para encontrar el stock ingresado
     * @param stockCode El número de stock
     * @return Unidades vendidas de ese stock
     */
    
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

    /*
     * Recorre la lista y encuentra un número de factura en común
     * @param invoiceNo El número de la factura a buscar 
     * @return La factura solicitada
     */
    
    public ArrayList<Compra> findByInvoiceNo(String invoiceNo) {
    	listaCompras = rc.ReadFromPath("csv/data.csv");
        ArrayList<Compra> arraylist = new ArrayList<>();

        for (Compra compra : listaCompras) {
            String  factura = compra.getInvoiceNo();
            if (invoiceNo.equalsIgnoreCase(factura)) {
                arraylist.add(compra);
            }
        }
        return arraylist;
    }
    
    /*
     * 
     */
    
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

    /*
     * Este método fue desarrollado con la colaboración de nuestros compañeros de clase, no es de nuestra autoria
     * Busca el producto por pais, obtiene la cantidad vendida y saca el promedio por país
     * @param groupByCountry El país ingresado
     * @return Promedio de ventas mensuales, Promedio de ventas mensuales por país
     */
    
    public List <String> avgMonthSales(boolean groupByCountry) {
        HashMap <String, Double> averageCountry = new HashMap <String, Double> ();
        HashMap <String, Integer> quantity = new HashMap <String, Integer> ();
        List <Compra> list = rc.ReadFromPath("csv/data.csv");
        if(groupByCountry) {
            for(Compra compra : list) {
                if(!averageCountry.containsKey(compra.getCountry())) {
                    averageCountry.put(compra.getCountry(), compra.getUnitPrice() * compra.getQuantity());
                    quantity.put(compra.getCountry(), 1);
                }else {
                    double current = averageCountry.get(compra.getCountry());
                    averageCountry.replace(compra.getCountry(), ((current) + (compra.getUnitPrice() * compra.getQuantity())));
                    quantity.replace(compra.getCountry(), quantity.get(compra.getCountry()) +1);
                }
            }
            for(String index : averageCountry.keySet())
                averageCountry.replace(index, (averageCountry.get(index) / quantity.get(index)));
            List <String> lista = new ArrayList<String> ();
            for(Map.Entry<String, Double> index :  averageCountry.entrySet())
                lista.add(index.getKey() + " = " + index.getValue() + "\n");
            return lista;
        }else {
            HashMap <Integer, Double> month = new HashMap <Integer, Double> ();
            HashMap <Integer, Integer> quanti = new HashMap <Integer, Integer> ();
            for(Compra compra : list) {
                String data [] = compra.getInvoiceDate().split("/");
                if(!month.containsKey(Integer.parseInt(data[0]))) {
                    month.put(Integer.parseInt(data[0]), compra.getUnitPrice() * compra.getQuantity());
                    quanti.put(Integer.parseInt(data[0]), 1);
                }else {
                    double current = month.get(Integer.parseInt(data[0]));
                    month.replace(Integer.parseInt(data[0]), (current + (compra.getUnitPrice() * compra.getQuantity())));
                    quanti.replace(Integer.parseInt(data[0]), quanti.get(Integer.parseInt(data[0]) +1));
                }
            }
            for(Integer index : month.keySet())
                month.replace(index, (month.get(index) / quanti.get(index)));
            List <String> lista = new ArrayList<String> ();
            for(Map.Entry<Integer, Double> index :  month.entrySet())
                lista.add(index.getKey() + " = " + index.getValue() + "\n");
            return lista;
        }
    }

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

}
