package coffeeproject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class CustomerFavorDTO {
	private String customerid;
	private int price;
	private int caffeine;
	private int sugar;
	private int quality;
	private int distance;
	//선호도를 표기하는데 필요한 정보이기도 하다, distance를 int값으로 받은 이유 : 선호도이기 때문
}

