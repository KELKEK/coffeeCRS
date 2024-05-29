package com.shinhan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coffeeproject.CoffeeDTO;
import coffeeproject.CustomerDTO;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter(urlPatterns = {"/cof/favor.do", "/cof/customerlogin.do"})
public class LoginCheckFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoginCheckFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//로그인하지 않으면 업무로직 수행 못함
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rep = (HttpServletResponse)response;
		HttpSession session = req.getSession();

		
		//webshop/auth/login.do 이런식으로 URI가 옴
		if(!req.getRequestURI().endsWith("login.do")) {
			//로그인하지 않으면 지나갈 수 없게
			session.setAttribute("lastRequest", req.getRequestURI());
			CustomerDTO ccus = (CustomerDTO)session.getAttribute("loginCus");
			//처음에는 바로 로그인값을 못받았기 때문에 로그인창에서부터 시작하게 됨
			if(ccus == null) {
				//로그인 되어있지 않으면 브라우저로 내려가서 로그인창으로 재요청함
				String path = req.getServletContext().getContextPath();
				rep.sendRedirect(path + "/cof/selectmode.do");
				return;
			}
			
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
