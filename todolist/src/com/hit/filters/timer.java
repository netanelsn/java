package com.hit.filters;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class timer
 */
@WebFilter(servletNames = {"TodolistServlet", "authenticationServlet"})
public class timer implements Filter {

    /**
     * Default constructor. 
     */
    public timer() {
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

		// pass the request along the filter chain

		System.out.print("before"); 
		long startTime = System.nanoTime();
		chain.doFilter(request, response);
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.print("after" + TimeUnit.NANOSECONDS.toSeconds(totalTime) +"."+ TimeUnit.NANOSECONDS.toMillis(totalTime));
		
		/*calculate loading time and save it as attribute*/
		request.getServletContext().setAttribute("loadingTime", TimeUnit.NANOSECONDS.toSeconds(totalTime) +"."+ TimeUnit.NANOSECONDS.toMillis(totalTime));
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Init method is called in " + this.getClass().getName());
	}

}
