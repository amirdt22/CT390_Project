package craig_proj;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class SecurityAuditFilter
 */
@WebFilter("/SecurityAuditFilter")
public class SecurityAuditFilter implements Filter {

	protected FilterConfig filterConfig;
	
    public SecurityAuditFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
		filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
   
	      String usr = request.getParameter("username");

	      System.out.println("Login attempts for "+ usr + ", Time "
	                                       + new Date().toString());
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
