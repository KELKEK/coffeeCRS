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

import coffeeproject.CoffeeDTO;
import coffeeproject.CoffeeService;
import coffeeproject.CustomerDTO;
import coffeeproject.CustomerService;

/**
 * Servlet implementation class CoffeeInsertServlet
 */
@WebServlet("/cof/coffeeinsert.do")
public class CoffeeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoffeeInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("coffeeInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		CoffeeDTO cof = makeCus(request);
		CoffeeService service = new CoffeeService();
		int result = service.coffeeInsert(cof);
		System.out.println(result+"건 입력됨");
		request.setAttribute("coffee_brandid", cof.getCoffee_brandid());
		if(result > 0) {
			request.setAttribute("message", "입력에 성공하였습니다!");
			RequestDispatcher rd = request.getRequestDispatcher("coffeeUpdateSuccess.jsp");
			rd.forward(request, response);
		}else {
			// 경고창을 띄우는 JavaScript 코드를 문자열로 작성
		    String alertScript = "<script>alert('입력에 실패했습니다.');</script>";
		    // HttpServletResponse 객체를 사용하여 출력 스트림을 얻음
		    PrintWriter out = response.getWriter();
		    // JavaScript 코드를 클라이언트에게 전송
		    out.println(alertScript);
		    // 이후에 필요한 작업을 수행
			RequestDispatcher rd = request.getRequestDispatcher("coffeeInsert.jsp");
			rd.forward(request, response);
		}
	}
	
	private CoffeeDTO makeCus(HttpServletRequest request) {
		Enumeration<String> colnames = request.getParameterNames();
		//Enumeration : 한정된 값의 나열(속성 전부가 문자열로 옮)
		while(colnames.hasMoreElements()) {
			String col = colnames.nextElement();
			System.out.println(col + "=>" + request.getParameter(col));
		}//파라미터로 넘어온 값들이 한 번에 들어옴
		
		CoffeeDTO cof = new CoffeeDTO();
		int coffee_brandid = Integer.parseInt(request.getParameter("coffee_brandid"));
		String coffeename = request.getParameter("coffeename");
		int price = Integer.parseInt(request.getParameter("price"));
		int caffeine = Integer.parseInt(request.getParameter("caffeine"));
		int sugar = Integer.parseInt(request.getParameter("sugar"));
		int quality = Integer.parseInt(request.getParameter("quality"));
		
		cof.setCoffee_brandid(coffee_brandid);
		cof.setCoffee_name(coffeename);
		cof.setPrice(price);
		cof.setCaffeine(caffeine);
		cof.setSugar(sugar);
		cof.setQuality(quality);
		
		
		return cof;
	}

}
