package coffeeproject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class CoffeeBrandDTO {
	private int coffee_brandid;
	private String sellerid;
	private String nickname;
	private String pword;
	private String phone;
	private String coffee_brandname;
	private int dist_x;
	private int dist_y;	
}
