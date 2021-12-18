package ShoppingCartAPI;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
	public ArrayList<moneyDiscount> mKey;
	public ArrayList<percentDiscount> pKey;
	public HashMap<Customer, Cart> userCart;
	public ArrayList<Item> stock;
	
	public Database(){
		this.mKey = new ArrayList<moneyDiscount>();
		this.pKey = new ArrayList<percentDiscount>();
		this.userCart = new HashMap<Customer, Cart>();
		this.stock = new ArrayList<Item>();
	}
	
//	public void setStock(ArrayList<Item> items) {
//		this.stock = items;
//	}
	
}
