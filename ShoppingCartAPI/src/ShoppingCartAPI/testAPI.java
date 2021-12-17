package ShoppingCartAPI;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import junit.framework.TestCase;

public class testAPI extends TestCase {
	private static int testsPassed;
	private static int numberOfTests;
	//set up database before test
	Database db = new Database();
	

	
	@Test
	public void testViewEmptyCart() {
		//putting in DB
		ArrayList<Item> items = new ArrayList<Item>();
		Item i1 = new Item(1,"Macbook Air","Apple Macbook Air 2018 13inch", 1399.99, 30);
		Item i2 = new Item(2,"Coach Wallet","leather wallet for male or female",249.59, 1);
		Item i3 = new Item(3,"Rose-Hulman T-shirt","Rose-Hulman fighting engineer shirt", 14.99, 2);
		items.add(i1);
		items.add(i2);
		items.add(i3);
		db.stock = items;
		Address bowen_addr = new Address(State.Indiana,City.TerreHaute,"5500 Wabash Avenue","2321");
		Cart bowen_cart = new Cart(db);
		Customer bowen = new Customer(bowen_cart, bowen_addr, 1, db);
		db.userCart.put(bowen, bowen_cart);
		
		
		shopMain main = new shopMain(db);
		assertEquals("Total Number of Item: 0; ", main.handleViewCart(1, db));
		testsPassed++;
	
	}
	
//	@Test
//	public void testViewCart_oneItem() {
//		//putting in DB
//		ArrayList<Item> items = new ArrayList<Item>();
//		Item i1 = new Item(1,"Macbook Air","Apple Macbook Air 2018 13inch", 1399.99, 30);
//		Item i2 = new Item(2,"Coach Wallet","leather wallet for male or female",249.59, 1);
//		Item i3 = new Item(3,"Rose-Hulman T-shirt","Rose-Hulman fighting engineer shirt", 14.99, 2);
//		items.add(i1);
//		items.add(i2);
//		items.add(i3);
//		db.stock = items;
//		Address bowen_addr = new Address(State.Indiana,City.TerreHaute,"5500 Wabash Avenue","2321");
//		Cart bowen_cart = new Cart(db);
//		
//		Customer bowen = new Customer(bowen_cart, bowen_addr, 1, db);
//		db.userCart.put(bowen, bowen_cart);
//		shopMain main = new shopMain(db);
//		System.out.println(main.handleViewCart(1, db));
//		assertEquals("Total Number of Item: 0; ", main.handleViewCart(1, db));
//		testsPassed++;
//	
//	}
	
	
	@Test
	public void testAddItem() {
		//putting in DB
		ArrayList<Item> items = new ArrayList<Item>();
		Item i1 = new Item(001,"Macbook Air","Apple Macbook Air 2018 13inch", 1399.99, 30);
		Item i2 = new Item(002,"Coach Wallet","leather wallet for male or female",249.59, 1);
		Item i3 = new Item(003,"Rose-Hulman T-shirt","Rose-Hulman fighting engineer shirt", 14.99, 2);
		items.add(i1);
		items.add(i2);
		items.add(i3);
		db.stock = items;
		Address bowen_addr = new Address(State.Indiana,City.TerreHaute,"5500 Wabash Avenue","2321");
		Cart bowen_cart = new Cart(db);
		
		Customer bowen = new Customer(bowen_cart, bowen_addr, 1, db);
		db.userCart.put(bowen, bowen_cart);
		shopMain main = new shopMain(db);
		assertEquals("Successful", main.handleAddItem(1,001, db));
		//System.out.println(bowen_cart.items.size());
		assertTrue(bowen_cart.items.keySet().contains(i1));
		testsPassed++;
		
	}
	
}
