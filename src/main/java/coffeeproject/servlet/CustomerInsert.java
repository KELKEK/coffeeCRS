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

import coffeeproject.CustomerDTO;
import coffeeproject.CustomerFavorDTO;
import coffeeproject.CustomerService;

/**
 * Servlet implementation class CustomerInsert
 */
@WebServlet("/cof/customerinsert.do")
public class CustomerInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("customerJoin.jsp").forward(request, response);
 
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		CustomerDTO cus = makeCus(request);
		CustomerFavorDTO cusf = makeFavor(request);
		CustomerService service = new CustomerService();
		int result = service.cusInsert(cus);
		int result2 = service.cusfavorInsert(cusf);
		System.out.println(result+"건 입력됨");
		System.out.println(result2+"건 입력됨");
		
		if(result > 0) {
			response.sendRedirect("customerlogin.do");
		}else {
	    	String message = "이미 가입되어있는 회원입니다.";
	    	request.setAttribute("errorMessage", message);
		    // 이후에 필요한 작업을 수행
			RequestDispatcher rd = request.getRequestDispatcher("customerJoin.jsp");
			rd.forward(request, response);
		}
		
	}
	
	private CustomerFavorDTO makeFavor(HttpServletRequest request) {
		Enumeration<String> colnames = request.getParameterNames();
		//Enumeration : 한정된 값의 나열(속성 전부가 문자열로 옮)
		while(colnames.hasMoreElements()) {
			String col = colnames.nextElement();
			System.out.println(col + "=>" + request.getParameter(col));
		}//파라미터로 넘어온 값들이 한 번에 들어옴
		
		CustomerFavorDTO cusf = new CustomerFavorDTO();
		String customerid = request.getParameter("customerid");
		int price = Integer.parseInt(request.getParameter("price"));
		int caffeine = Integer.parseInt(request.getParameter("caffeine"));
		int sugar = Integer.parseInt(request.getParameter("sugar"));
		int quality = Integer.parseInt(request.getParameter("quality"));
		int distance = Integer.parseInt(request.getParameter("distance"));
		
		cusf.setCustomerid(customerid);
		cusf.setPrice(price);
		cusf.setCaffeine(caffeine);
		cusf.setSugar(sugar);
		cusf.setQuality(quality);
		cusf.setDistance(distance);
		
		return cusf;
	}
	
	private CustomerDTO makeCus(HttpServletRequest request) {
		Enumeration<String> colnames = request.getParameterNames();
		//Enumeration : 한정된 값의 나열(속성 전부가 문자열로 옮)
		while(colnames.hasMoreElements()) {
			String col = colnames.nextElement();
			System.out.println(col + "=>" + request.getParameter(col));
		}//파라미터로 넘어온 값들이 한 번에 들어옴
		
		CustomerDTO cus = new CustomerDTO();
		String customerid = request.getParameter("customerid");
		String pword = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone");
		
		cus.setCustomerid(customerid);
		cus.setPword(pword);
		cus.setNickname(nickname);
		cus.setPhone(phone);
		
		return cus;
	}


}
