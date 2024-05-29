package coffeeproject;

import java.util.List;

public class CoffeeService {
	CoffeeDAO coffeeDAO = new CoffeeDAO();
	//0, 커피메뉴판
	public List<CoffeeDTO> coffeeMenu(int brandid){
		return coffeeDAO.coffeeMenu(brandid);
	}
	
	//1, 커피집 등록
	public int coffeebrandInsert(CoffeeBrandDTO coffeebrand) {
		return coffeeDAO.coffeebrandInsert(coffeebrand);
	}
	
	//2, 커피 로그인
	public CoffeeBrandDTO sellerLogin(String Id, String Pw) {
		return coffeeDAO.sellerLogin(Id, Pw);
	}
	
	//3, 커피 등록
	public int coffeeInsert(CoffeeDTO coffee) {
		return coffeeDAO.coffeeInsert(coffee);
	}
	
	//4, 커피 삭제
	public int coffeeDelete(int coffee_id) {
		return coffeeDAO.coffeeDelete(coffee_id);
	}
	
	//5, 회원탈퇴(커피집탈퇴)
	public int sellerDelete(String id, String pw, String phone) {
		return coffeeDAO.sellerDelete(id, pw, phone);
	}
}
