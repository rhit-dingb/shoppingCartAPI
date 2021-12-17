package ShoppingCartAPI;

public class Item {
	int itemID;
	String itemName;
	String description;
	double price;
	int stock;
	
	boolean checkIsValid() {
		return false;
	}
	
	public Item(int itemID, String itemName, String description, double price, int stock) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}
	
}
