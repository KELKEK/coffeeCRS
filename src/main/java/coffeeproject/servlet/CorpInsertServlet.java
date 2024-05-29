package coffeeproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffeeproject.CoffeeBrandDTO;
import coffeeproject.CoffeeService;

/**
 * Servlet implementation class CorpInsertServlet
 */
@WebServlet("/cof/corpinsert.do")
public class CorpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorpInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("coffeeBrandJoin.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				request.setCharacterEncoding("utf-8");
				CoffeeBrandDTO cofb = makeCus(request);
				CoffeeService service = new CoffeeService();
				int result = service.coffeebrandInsert(cofb);
				System.out.println(result+"건 입력됨");
				
				if(result > 0) {
					response.sendRedirect("corplogin.do");
				}else {
			    	// 입력 정보가 달라 삭제에 실패한 경우
			    	String message = "이미 가입되어있는 회원입니다.";
			    	request.setAttribute("errorMessage", message);
					RequestDispatcher rd = request.getRequestDispatcher("coffeeBrandJoin.jsp");
					rd.forward(request, response);
				}
	}

	private CoffeeBrandDTO makeCus(HttpServletRequest request) {
		Enumeration<String> colnames = request.getParameterNames();
		//Enumeration : 한정된 값의 나열(속성 전부가 문자열로 옮)
		while(colnames.hasMoreElements()) {
			String col = colnames.nextElement();
			System.out.println(col + "=>" + request.getParameter(col));
		}//파라미터로 넘어온 값들이 한 번에 들어옴
		
		CoffeeBrandDTO cofb = new CoffeeBrandDTO();
		String coffee_brandname = request.getParameter("coffee_brandname");
		int coffee_brandid = Integer.parseInt(request.getParameter("coffee_brandid"));
		String sellerid = request.getParameter("sellerid");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone");
		int dist_x = Integer.parseInt(request.getParameter("dist_x"));
		int dist_y = Integer.parseInt(request.getParameter("dist_y"));
		
		cofb.setCoffee_brandname(coffee_brandname);
		cofb.setCoffee_brandid(coffee_brandid);
		cofb.setSellerid(sellerid);
		cofb.setPword(password);
		cofb.setNickname(nickname);
		cofb.setPhone(phone);
		cofb.setDist_x(dist_x);
		cofb.setDist_y(dist_y);

		return cofb;
	}

}
