package ShoppingCartAPI;
public class Customer {
	int id;
	Address addr;
	Cart cart;
	Tax tax;
	public Customer(Address addr, int id, Database db) {
		this.addr = addr;
		this.cart = new Cart(db, addr);
		this.id = id;
		this.tax = new Tax(addr.state);
	}
	
	public Cart getCart() {
		return this.cart;
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
	
	public Address getAddress() {
		return this.addr;
	}
}
