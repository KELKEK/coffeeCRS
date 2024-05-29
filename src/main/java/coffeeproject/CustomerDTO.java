package coffeeproject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@ToString@Setter
public class CustomerDTO {
	private String customerid;
	private String nickname;
	private String pword;
	private String phone;
	private int dist_x;
	private int dist_y;
}
