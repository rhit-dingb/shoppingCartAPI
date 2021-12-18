package ShoppingCartAPI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class moneyDiscount extends Discount {

	double moneyOff;
	public moneyDiscount(Database db,String discountCode, Date expirationDate, double moneyOff, ArrayList<Item> applyItems) {
		super(db, discountCode, expirationDate, applyItems);
		this.moneyOff = moneyOff;
	}
	
	public boolean isValid() {
		for(Discount d : db.mKey){
			if(d.discountCode.equals(this.discountCode)) {
				if(d.expirationDate.after(Calendar.getInstance().getTime())) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
	
	public double getDiscount() {
		return this.moneyOff;
	}
}
