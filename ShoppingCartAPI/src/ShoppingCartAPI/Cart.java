package ShoppingCartAPI;
import java.util.ArrayList;
import java.util.HashMap;

public class Cart {
	HashMap<Item, Integer> items;
	Database db;
	double simpleTotal;
	double discountTotal;
	double estimatedTax;
	double finalValue;
	
	public Cart(Database db) {
		this.items = new HashMap<Item, Integer>();
		simpleTotal = 0;
		discountTotal = 0;
		estimatedTax = 0;
		finalValue = 0;
		this.db = db;
	}
    double sumItemTotal() {
    	for(Item i : items.keySet()) {
    		simpleTotal += i.price;
    	}
		return simpleTotal;
	}
    
    public Boolean isInStock(int itemID) {
    	int demand = 0;
    	for(Item i : this.items.keySet()) {
    		if(i.itemID == itemID) {
    			demand = items.get(i);
    		}
    	}
    	int stock = 0;
    	for(Item i : db.stock) {
    		if(i.itemID == itemID) {
    			stock = i.stock;
    		}
    	}
    	if(demand > stock) {
    		return false;
    	}
    	
    	return true;
    	
    }
    
    double calculateTax(double discountedTotal){
		return discountedTotal;
    	
    }
    String viewCart() {
    	
    	String totalNumberItem = "Total Number of Item: ";
    	totalNumberItem += this.items.size()+ "; ";
    	String itemTxt = "";
    	for(Item i: items.keySet()) {
    		itemTxt += "Item Name: " + i.itemName + ", ";
    		itemTxt += "Item Description: " + i.description + ", ";
    		itemTxt += "Item Price: " + i.price + "; ";
    		//itemTxt += "Item Picture: " + i.itemName + ",";
    		itemTxt += "Item available: " + this.isInStock(i.itemID) + "; ";
    	}
    		
		return totalNumberItem + itemTxt;
    	
    	
    }
    Boolean addItem(int itemID, Database db){
    	
    	for(Item i : db.stock) {
    		if(i.itemID == itemID) {
    			if(i.stock < 1) {
    				return false;
    			}
    			else {
    				this.items.put(i, 1);
    			}
    		}
    	}
    	
		return true;
    	
    	//return message of added quantity
    }
    String changeQuantity(int itemID, int newQuantity){
    	return "change quantity not successful, Reason: ";
    	
    	//return message of is changed quantity
    }
}
