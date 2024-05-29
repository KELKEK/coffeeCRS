package coffeeproject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class CoffeeDTO {
	private int coffee_id;
	private int coffee_brandid;
	private String coffee_name;
	private int price;
	private int caffeine;
	private int sugar;
	private int quality;
}



//DTO(Data Transfer Object), 데이터가 전송될 때는 항상 DTO를 이용한다.(한 건에 여러 데이터를 담기 위해 필요한 클래스)
//JavaBeans기술에서 이용(JSP, String, Mybatis는 javabeans기술을 이용한다.)
//어떤 곳에선 DTO 대신 VO라고 하기도 한다.