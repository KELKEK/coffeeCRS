package coffeeproject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffeeproject.CustomerDTO;
import coffeeproject.CustomerService;

/**
 * Servlet implementation class CustomerDeleteServlet
 */
@WebServlet("/cof/cusdelete.do")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("deletecus.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerid = request.getParameter("customerid");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		CustomerService service = new CustomerService();
		
		int result = service.cusDelete(customerid, password, phone);
	    if (result < 1) {
	    	// 입력 정보가 달라 삭제에 실패한 경우
	    	String message = "입력 정보가 달라 삭제에 실패하였습니다.";
	    	request.setAttribute("errorMessage", message);
	    	request.getRequestDispatcher("deletecus.jsp").forward(request, response);
	    } else {
	        // 삭제가 성공한 경우 crs.do로 이동합니다.
	        response.sendRedirect("crs.do");
	    }
	}

}
