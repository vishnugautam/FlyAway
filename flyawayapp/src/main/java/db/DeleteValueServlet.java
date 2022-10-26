package db;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import flyawayapp.model.FlightDetails;
import flyawayapp.utils.HibernateUtils;


public class DeleteValueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		String identity = request.getParameter("id");
		int identityInt = Integer.parseInt(identity);
		
		
		// retrieve the transcation
		session.beginTransaction();
		
		// select the row to delete
		String sqlRow = "DELETE FROM `flyaway`.`flightdetails` WHERE (`id` = " + identityInt + ");";
		NativeQuery rowQuery = session.createSQLQuery(sqlRow); 
		int row = rowQuery.executeUpdate();
		
		// committing the session
		session.getTransaction().commit();
		session.close();
		request.getRequestDispatcher("FlightDetails.jsp").forward(request, response);
		
		
		
	}
	
	

}
