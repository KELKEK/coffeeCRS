package coffeeproject.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coffeeproject.CustomerDTO;
import coffeeproject.CustomerService;

/**
 * Servlet implementation class CoffeeLoginServlet
 */
@WebServlet("/cof/customerlogin.do")
public class CoffeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoffeeLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //login창 보여주기 
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("coffeelogin.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 입력한 ID, pass검사
				CustomerService service = new CustomerService();
				String uname = request.getParameter("uname");
				String psw = request.getParameter("psw");
				CustomerDTO ccus = service.login(uname, psw);
				if(ccus==null || ccus.getCustomerid().equals("-1")) {			
					//존재하지않는 직원
					request.setAttribute("message", "존재하지않는 계정");
				}else if(ccus.getCustomerid().equals("-2")) {
					//비밀번호오류 
					request.setAttribute("message", "비밀번호오류 ");
				}else {
					//로그인성공
					HttpSession session = request.getSession();
					session.setAttribute("loginCus", ccus);
					String remember = request.getParameter("remember");
					System.out.println(remember);
					session.setAttribute("kind", remember);

					response.sendRedirect("cusmain.do");
					return;
				}
				
				RequestDispatcher rd;
				rd = request.getRequestDispatcher("result.jsp");
				rd.forward(request, response);
	}

}
