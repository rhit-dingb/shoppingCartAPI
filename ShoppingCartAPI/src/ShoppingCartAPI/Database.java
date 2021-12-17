package ShoppingCartAPI;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
	public ArrayList<Discount> discountKey;
	public HashMap<Customer, Cart> userCart;
	public ArrayList<Item> stock;
	
	public Database(){
		this.discountKey = new ArrayList<Discount>();
		this.userCart = new HashMap<Customer, Cart>();
		this.stock = new ArrayList<Item>();
	}
	
//	public void setStock(ArrayList<Item> items) {
//		this.stock = items;
//	}
	
}
