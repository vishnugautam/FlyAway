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
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		// to select source 
		String sqlSource = "SELECT source FROM flyaway.flightdetails;";
		NativeQuery sourceQuery = session.createSQLQuery(sqlSource);
		List sourceResults = sourceQuery.list();
		System.out.println(sourceResults);
		List<String> arraySourceResults = new ArrayList<String>();
		arraySourceResults.addAll(sourceResults);
		System.out.println(arraySourceResults);
		
		// to select destination
		String sqlDestination = "SELECT destination FROM flyaway.flightdetails;";
		NativeQuery destinationQuery = session.createSQLQuery(sqlDestination);
		List destinationResults = destinationQuery.list();
		System.out.println(destinationResults);
		List<String> arrayDestinationResults = new ArrayList<String>();
		arrayDestinationResults.addAll(destinationResults);
		System.out.println(arrayDestinationResults);
		
			if((arraySourceResults.contains(source)) && (arrayDestinationResults.contains(destination))) {
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
