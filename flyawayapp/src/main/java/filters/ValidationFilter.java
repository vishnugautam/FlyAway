package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;

import flyawayapp.utils.HibernateUtils;

public class ValidationFilter implements Filter {

  
    public ValidationFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		
		if (source == null || destination == null ) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("index.jsp").include(request, response);
			out.println("<span style='color:red'>Invalid Source or Destination</span>");
		} else {
			Session session = HibernateUtils.getSessionFactory().openSession();
			request.getRequestDispatcher("FlightList.jsp").forward(request, response);
			System.out.println("Bye from filter");
			
		}
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
