package db;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import flyawayapp.model.FlightDetails;
import flyawayapp.utils.HibernateUtils;

public class InsertValueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String departure = request.getParameter("departure");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		try {
			startDate = sdf.parse(departure);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String price = request.getParameter("price");
		int priceInt = Integer.parseInt(price);
		String airline = request.getParameter("airlines");
		
		
		// Retrieve the transaction 
		session.beginTransaction();
		
		FlightDetails fd = new FlightDetails();
		fd.setSource(source);
		fd.setDestination(destination);
		fd.setDeparture(startDate);
		fd.setPrice(priceInt);
		fd.setAirlines(airline);
		
		session.save(fd);
		
		// committing the session
		session.getTransaction().commit();
		session.close();
		request.getRequestDispatcher("FlightDetails.jsp").forward(request, response);
	}

}
