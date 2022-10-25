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


public class AdminFilter implements Filter {


    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		
		if(name == null && password == null) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("admin.jsp").include(request, response);
			out.println("<h3 color='red'>Invalid admin name or password!");
		} else {
			Session session = HibernateUtils.getSessionFactory().openSession();
			request.getRequestDispatcher("FlightDetails.jsp").forward(request, response);
			System.out.println("Bye from filter");
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
