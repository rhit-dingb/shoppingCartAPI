package ShoppingCartAPI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public abstract class Discount {
	String discountCode;
	Date expirationDate;
	Database db;
	ArrayList<Item> applyItems = new ArrayList<Item>();
	public Discount(Database db, String discountCode, Date expirationDate, ArrayList<Item> applyItems) {
		this.db = db;
		this.discountCode = discountCode;
		this.expirationDate = expirationDate;
		this.applyItems = applyItems;
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
	
}
