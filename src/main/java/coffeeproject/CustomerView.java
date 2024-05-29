package coffeeproject;
//View : 사용자에게 어떻게 보여줄지를 담당, JSP로 담당할 에정

import java.util.List;

public class CustomerView {

	public static void print(String message) {
		// TODO Auto-generated method stub
		// 결과를 나타내주는 메세지를 출력하는 함수
		System.out.printf("==========================%s============================\n", message);
	}

	public static void print(List<Object> cof) {
		// TODO Auto-generated method stub
		if (cof.size() == 0) {
			System.out.println("추천에 실패하였습니다.");
			return;
		}
		cof.stream().forEach(p -> System.out.println(p));
	}

	public static void print(List<Object> menu, String string) {
		// TODO Auto-generated method stub
		if(menu.size() == 0) {
			System.out.println("존재하지 않는 계정입니다. 다시 입력해주세요");
			return;
		}
		System.out.printf("===========%s===========\n", string);
		menu.stream().forEach(m -> System.out.println(m));
	}

}
