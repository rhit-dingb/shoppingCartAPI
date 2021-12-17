package ShoppingCartAPI;
public class Customer {
	int id;
	Address addr;
	Cart cart;
	
	public Customer(Cart cart, Address addr, int id, Database db) {
		this.addr = addr;
		this.cart = cart;
		this.id = id;
	}
	
	String viewCart() {
		return cart.viewCart();
	}
	
	String addItemToCart(int itemID, Database db) {
		
		boolean isSuccess = cart.addItem(itemID, db);
		if(isSuccess == true) {
			return "Successful";
		}
		else {
			return "Out of Stock!";
		}
	}
}
