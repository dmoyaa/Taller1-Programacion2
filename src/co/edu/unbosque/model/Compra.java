package co.edu.unbosque.model;

public class Compra {
	
	/*
	 * Atributos del csv 
	 */
	
	private String InvoiceNo;
	private String StockCode;
	private String Description;
	private int Quantity;
	private String InvoiceDate;
	private double UnitPrice;
	private String CustomerID;
	private String Country;
	
	/*
	 * Todos los atributos que contiene el método de compra, requeridos en otros métodos
	 */
	
	public Compra(String IN, String SC, String Des, int Qua, String ID, double UP, String CI,
			String Cou) {
		
		this.InvoiceNo = IN;
		this.StockCode = SC;
		this.Description = Des;
		this.Quantity = Qua;
		this.InvoiceDate = ID;
		this.UnitPrice = UP;
		this.CustomerID = CI;
		this.Country = Cou;
		
	}

	

	public String getInvoiceNo() {
		return InvoiceNo;
	}



	public void setInvoiceNo(String invoiceNo) {
		InvoiceNo = invoiceNo;
	}



	public String getStockCode() {
		return StockCode;
	}

	public void setStockCode(String stockCode) {
		StockCode = stockCode;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String getInvoiceDate() {
		return InvoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		InvoiceDate = invoiceDate;
	}

	public double getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		UnitPrice = unitPrice;
	}

	public String getCustomerID() {
		return CustomerID;
	}



	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}



	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	/*
	 * Imprime los atributos del csv
	 */
	
	@Override
	public String toString() {
		return "Compra [InvoiceNo=" + InvoiceNo + ", StockCode=" + StockCode + ", Description=" + Description
				+ ", Quantity=" + Quantity + ", InvoiceDate=" + InvoiceDate + ", UnitPrice=" + UnitPrice
				+ ", CustomerID=" + CustomerID + ", Country=" + Country + "]" + "\n";
	}

	
	
	
}
