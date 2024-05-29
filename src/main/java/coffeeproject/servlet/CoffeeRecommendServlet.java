package coffeeproject.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffeeproject.CustomerService;

/**
 * Servlet implementation class CoffeeRecommendServlet
 */
@WebServlet("/cof/recommend.do")
public class CoffeeRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoffeeRecommendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService service = new CustomerService();
        String customerid = request.getParameter("customerid");
        String nickname = request.getParameter("nickname");
        request.setAttribute("customerid", customerid);
        request.setAttribute("nickname", nickname);
        Map<String, String> cof = service.recommend(customerid);
        System.out.println(customerid);
        System.out.println(cof.get("coffeebrand"));
        System.out.println(cof.get("coffeename"));
        request.setAttribute("coffeebrand", cof.get("coffeebrand"));
        request.setAttribute("coffeename", cof.get("coffeename"));
        request.getRequestDispatcher("coffeeRecommend.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
