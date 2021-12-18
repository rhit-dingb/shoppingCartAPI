package ShoppingCartAPI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.Test;

import junit.framework.TestCase;

public class testAPI extends TestCase {
	private static int testsPassed;
	private static int numberOfTests;
	// set up database before test
	Database db = new Database();

	@Test
	public void testViewEmptyCart() {
		// putting in DB
		ArrayList<Item> items = new ArrayList<Item>();
		Item i1 = new Item(1, "Macbook Air", "Apple Macbook Air 2018 13inch", 1399.99, 30);
		Item i2 = new Item(2, "Coach Wallet", "leather wallet for male or female", 249.59, 1);
		Item i3 = new Item(3, "Rose-Hulman T-shirt", "Rose-Hulman fighting engineer shirt", 14.99, 2);
		items.add(i1);
		items.add(i2);
		items.add(i3);
		db.stock = items;
		Address bowen_addr = new Address(State.Indiana, City.TerreHaute, "5500 Wabash Avenue", "2321");
		Customer bowen = new Customer(bowen_addr, 0, db);
		db.userCart.put(bowen, bowen.getCart());

		shopMain main = new shopMain(db);
		assertEquals("Total Number of Item: 0; Total cost of items: 0.0; Estimated Tax: 0.0; ", main.handleViewCart(0, db));
		testsPassed++;

	}

	@Test
	public void testAddItem() {
		// putting in DB
		ArrayList<Item> items = new ArrayList<Item>();
		Item i1 = new Item(001, "Macbook Air", "Apple Macbook Air 2018 13inch", 1399.99, 30);
		Item i2 = new Item(002, "Coach Wallet", "leather wallet for male or female", 249.59, 1);
		Item i3 = new Item(003, "Rose-Hulman T-shirt", "Rose-Hulman fighting engineer shirt", 14.99, 2);
		items.add(i1);
		items.add(i2);
		items.add(i3);
		db.stock = items;
		Address bowen_addr = new Address(State.Indiana, City.TerreHaute, "5500 Wabash Avenue", "2321");
		Customer bowen = new Customer(bowen_addr, 1, db);
		db.userCart.put(bowen, bowen.getCart());
		shopMain main = new shopMain(db);
		assertEquals("Successful", main.handleAddItem(1, 001, db));
		// System.out.println(bowen_cart.items.size());
		assertTrue(bowen.getCart().items.keySet().contains(i1));
		testsPassed++;
	}
	

	@Test
	public void testViewOneItem() {
		// putting in DB
		ArrayList<Item> items = new ArrayList<Item>();
		Item i1 = new Item(001, "Macbook Air", "Apple Macbook Air 2018 13inch", 1399.99, 30);
		Item i2 = new Item(002, "Coach Wallet", "leather wallet for male or female", 249.59, 1);
		Item i3 = new Item(003, "Rose-Hulman T-shirt", "Rose-Hulman fighting engineer shirt", 14.99, 2);
		items.add(i1);
		items.add(i2);
		items.add(i3);
		db.stock = items;
		Address bowen_addr = new Address(State.Indiana, City.TerreHaute, "5500 Wabash Avenue", "2321");
		Customer bowen = new Customer(bowen_addr, 1, db);
		db.userCart.put(bowen, bowen.getCart());
		shopMain main = new shopMain(db);
		assertEquals("Successful", main.handleAddItem(1, 001, db));
		assertEquals("Total Number of Item: 1; Item Name: Macbook Air, Item Description: Apple Macbook Air 2018 13inch, "
				+ "Item Price: 1399.99; Item available: true; Total cost of items: 1399.99; Estimated Tax: 112.0; ", main.handleViewCart(1, db));
		System.out.println(main.handleViewCart(1, db));
		
		
		testsPassed++;
	}
	
	@Test
	public void testApplyDiscount() throws ParseException {
		ArrayList<Item> items = new ArrayList<Item>();
		Item i1 = new Item(001, "Macbook Air", "Apple Macbook Air 2018 13inch", 1399.99, 30);
		Item i2 = new Item(002, "Coach Wallet", "leather wallet for male or female", 249.59, 1);
		Item i3 = new Item(003, "Rose-Hulman T-shirt", "Rose-Hulman fighting engineer shirt", 14.99, 2);
		items.add(i1);
		items.add(i2);
		items.add(i3);
		
		db.stock = items;
		Address bowen_addr = new Address(State.Indiana, City.TerreHaute, "5500 Wabash Avenue", "2321");
		Customer bowen = new Customer(bowen_addr, 1, db);
		db.userCart.put(bowen, bowen.getCart());
		String date_string = "2022-10-01";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(date_string);
		//percentDiscount pd1 = new percentDiscount(db, "AAA75",date, 0.05);
		
		shopMain main = new shopMain(db);
		assertEquals("Successful", main.handleAddItem(1, 001, db));
		assertEquals("Total Number of Item: 1; Item Name: Macbook Air, Item Description: Apple Macbook Air 2018 13inch, "
				+ "Item Price: 1399.99; Item available: true; Total cost of items: 1399.99; Estimated Tax: 112.0; ", main.handleViewCart(1, db));
		System.out.println(main.handleViewCart(1, db));
		
		
		
		
		
		
		
		
		
		testsPassed++;
	}

}
