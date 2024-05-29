package coffeeproject;
import java.util.List;
import java.util.Map;

public class CustomerService {
	CustomerDAO cusDAO = new CustomerDAO();
	
	//1, 회원가입(Insert)
	public int cusInsert(CustomerDTO cus) {
		return cusDAO.customInsert(cus);
	}
	
	//2, 로그인(login)
	public CustomerDTO login(String Id, String Pw){
		CustomerDTO cusDTO = cusDAO.customLogin(Id, Pw);
		return cusDTO;
	}
	
	//추천 커피 추출하기
	public Map<String, String> recommend(String id) {
		return cusDAO.customRecommend(id);
	}
	
	//로그인 확인
	public CustomerDTO login(String Id){
		CustomerDTO cusDTO = cusDAO.customLogin2(Id);
		return cusDTO;
	}
	
	//3, 회원선호도 입력
	public int cusfavorInsert(CustomerFavorDTO cusf) {
		return cusDAO.customFavor(cusf);
	}
	
	//4, 회원선호도 수정
	public int cusfavorUpdate(CustomerFavorDTO cusf) {
		return cusDAO.customFavorUpdate(cusf);
	}
	
	//5, 메뉴판 출력
	public List<Object> menu(){
		return cusDAO.customMenu();
	}
	
	//6, 회원 탈퇴
	public int cusDelete(String id, String pw, String phone) {
		return cusDAO.customDelete(id, pw, phone);
	}
	public int cusFavorDelete(String id) {
		return cusDAO.customFavorDelete(id);
	}
}
