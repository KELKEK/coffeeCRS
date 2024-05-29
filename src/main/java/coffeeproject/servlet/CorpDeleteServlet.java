package coffeeproject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffeeproject.CoffeeService;
import coffeeproject.CustomerService;

/**
 * Servlet implementation class CorpDeleteServlet
 */
@WebServlet("/cof/corpdelete.do")
public class CorpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorpDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("corpDelete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String sellerid = request.getParameter("sellerid");
	    String password = request.getParameter("password");
	    String phone = request.getParameter("phone");
	    CoffeeService service = new CoffeeService();

	    int result = service.sellerDelete(sellerid, password, phone);
	    if (result < 1) {
	    	// 입력 정보가 달라 삭제에 실패한 경우
	    	String message = "입력 정보가 달라 삭제에 실패하였습니다.";
	    	request.setAttribute("errorMessage", message);
	    	request.getRequestDispatcher("corpDelete.jsp").forward(request, response);
	    } else {
	        // 삭제가 성공한 경우 crs.do로 이동합니다.
	        response.sendRedirect("crs.do");
	    }
	}

}
