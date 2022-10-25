package filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.mysql.cj.Query;

import flyawayapp.model.FlightDetails;
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
		Session session1 = HibernateUtils.getSessionFactory().openSession();
		String sql = "SELECT SOURCE FROM flyaway.flightdetails;";
		NativeQuery sourceQuery = session1.createSQLQuery(sql);
		List results = sourceQuery.list();
		System.out.println(results);
		List<String> arrayResults = new ArrayList<String>();
		arrayResults.addAll(results);
		System.out.println(arrayResults);
		
			if(arrayResults.contains(source)) {
				request.getRequestDispatcher("FlightList.jsp").forward(request, response);
				System.out.println("Bye from filter");
			} else {
				request.getRequestDispatcher("index.jsp").include(request, response);
				PrintWriter out = response.getWriter();
				out.println("<span style='color:red'>Invalid Source or Destination</span>");
			}
		}
//		if (source == null || destination == null ) {
//			PrintWriter out = response.getWriter();
//			request.getRequestDispatcher("index.jsp").include(request, response);
//			out.println("<span style='color:red'>Invalid Source or Destination</span>");
//		} 
		


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
