package ShoppingCartAPI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class percentDiscount extends Discount {
	double percentOff;
	
	public percentDiscount(Database db,String discountCode, Date expirationDate, double percentOff, ArrayList<Item> applyItems) {
		super(db, discountCode, expirationDate, applyItems);
		this.percentOff = percentOff;
	}

	public boolean isValid() {
		for(Discount d : db.pKey){
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
		return this.percentOff;
	}
}
