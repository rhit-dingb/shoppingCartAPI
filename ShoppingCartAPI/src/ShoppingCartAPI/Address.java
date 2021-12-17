package ShoppingCartAPI;

public class Address {
	public State state;
	public City city;
	public String streetAddress;
	public String apartmentNumber;
	
	public Address(State state, City city, String streetAddress, String apartmentNumber){
		this.state = state;
		this.city = city;
		this.streetAddress = streetAddress;
		this.apartmentNumber = apartmentNumber;
	}

}


enum State{
	Alabama,
	Alaska,
	Arizona,
	Arkansas,
	California,
	Indiana,
	Illinois,
}


enum City{
	Chicago,
	TerreHaute,
	Indianapolis,
}