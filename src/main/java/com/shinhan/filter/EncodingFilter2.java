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

/**
 * Servlet Filter implementation class EncodingFilter2
 */
@WebFilter("*.do")
public class EncodingFilter2 extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public EncodingFilter2() {
        System.out.println("EncodingFilter 생성됨");
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
		   System.out.println("해당 요청전에 수행한다.");
		   //작업에 걸린시간 측정하기
		   long startTime = System.nanoTime();
		   
	       String path1 = ((HttpServletRequest)request).getContextPath();
	       String uri = ((HttpServletRequest)request).getRequestURI();
	       
	       String realPath = request.getRealPath(".");
	       
//	       System.out.println("path : " + path1);
//	       System.out.println("uri : " + uri);
//	       System.out.println("getRealPath : " + realPath);
	       request.setCharacterEncoding("utf-8");
	       //post 메서드에 대해 자동으로 utf-8을 적용시켜준다.
	       chain.doFilter(request, response);
	       System.out.println("해당 응답전에 수행한다.");
	       
	       long endTime = System.nanoTime();
	       System.out.println("해당업무를 수행하는데 걸리는 시간 : " + (endTime - startTime) + "ns");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
