package ShoppingCartAPI;

import java.util.ArrayList;

public class shopMain {
	
	ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public shopMain(Database db) {
		for(Customer c : db.userCart.keySet()) {
			customers.add(c);
		}
	}
	
	String handleViewCart(int CustomerID, Database db){
		for(Customer c : customers) {
			if(c.id == CustomerID) {
				return c.viewCart();
			}
		}
		return "ERROR";
	}
	String handleAddItem(int CustomerID, int itemID, Database db){
		for(Customer c : customers) {
			if(c.id == CustomerID) {
				return c.addItemToCart(itemID,db);
			}
		}
		return "ERROR";
	}
	void handleChangeQuantity(int CustomerID, int itemID, int newQuantity, Database db){
		
	}

	
	public static void main(String[] args) {
		//Database db = new Database();
		//manually adding some data in the mock database
		
		System.out.println("program started");
	}

}
