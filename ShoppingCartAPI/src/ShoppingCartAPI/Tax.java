package ShoppingCartAPI;
public class Tax {
	
	public State state;
	
	public Tax(State state) {
		this.state = state;
	}
	
	double getTax() {
		
		switch(state) {
			case Indiana:
				return 0.08;
			case Illinois:
				return 0.10;
			default:
				return 0;
		}
	}
}


