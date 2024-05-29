package coffeeproject.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffeeproject.CustomerFavorDTO;
import coffeeproject.CustomerService;

/**
 * Servlet implementation class CustomerFavorServlet
 */
@WebServlet("/cof/favor.do")
public class CustomerFavorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerFavorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("favorcheck.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		CustomerFavorDTO cus = updateFavor(request);
		CustomerService service = new CustomerService();
		int result = service.cusfavorUpdate(cus);
		System.out.println(result+"건 입력됨");
		
		response.sendRedirect("cusmain.do");
	}

	private CustomerFavorDTO updateFavor(HttpServletRequest request) {
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
		
		System.out.println(customerid);
		cusf.setCustomerid(customerid);
		cusf.setPrice(price);
		cusf.setCaffeine(caffeine);
		cusf.setSugar(sugar);
		cusf.setQuality(quality);
		cusf.setDistance(distance);

		return cusf;
	}

}
