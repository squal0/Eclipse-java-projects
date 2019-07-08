/**
 * The following class will simulate a hardware store runnings
 * this class mainly focuses on the invoices that are generated after a sale
 */
package hardware_invoice;

/**
 * @author Home
 *
 */
public class Invoice {

	/**
	 * @param args
	 */
	//instance variables that are to be used
	private String part_No;
	private String part_Description;
	private int quantity;
	private double price;
	
	public Invoice(String part_No, String part_Description, int quantity, double price){
		this.part_No = part_No;
		this.part_Description = part_Description;
		/*
		 * validate that both the price and the quantity are greater than 0
		 * if this is not the case then assign 0.0 to price and 0 to quantity
		 */
		if( quantity > 0 )
			this.quantity = quantity; //assign it to instance variable quantity
		if( price > 0)
			this.price = price; //assign it to instance variable price
	}
	public double getInvoiceAmount(double price, int quantity){
		return quantity * price;
	}
	public String getPart_No() {
		return part_No; //return the part_No value to the caller
	}
	public void setPart_No(String part_No) {
		this.part_No = part_No; //store the value in memory
	}
	public String getPart_Description() {
		return part_Description; //return the part_Description value to the caller
	}
	public void setPart_Description(String part_Description) {
		this.part_Description = part_Description; // store the value in memory
	}
	public void setQuantity( int quantity){
		this.quantity = quantity;
	}
	public int getQuantity(){
		return quantity;
	}
	public void setPrice( double price){
		this.price = price;
	}
	public double getPrice(){
		return price;
	}

}
