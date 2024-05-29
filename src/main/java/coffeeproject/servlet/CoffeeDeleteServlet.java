package coffeeproject.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffeeproject.CoffeeService;

/**
 * Servlet implementation class CoffeeDeleteServlet
 */
@WebServlet("/cof/coffeedelete.do")
public class CoffeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoffeeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int coffee_id = Integer.parseInt(request.getParameter("coffee_id"));
		int result = new CoffeeService().coffeeDelete(coffee_id);
		System.out.println(result+ "건 삭제됨");
		request.setAttribute("message", "삭제에 성공하였습니다!");
		
		RequestDispatcher rd = request.getRequestDispatcher("coffeeUpdateSuccess.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
