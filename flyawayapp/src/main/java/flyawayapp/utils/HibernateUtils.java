package flyawayapp.utils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
// this is one time activity
public class HibernateUtils {
	private static StandardServiceRegistry standardServiceRegistry;
	// it is a factory for your session
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		// session factory is an object, is used to create sessionobject which is like connection object in jdbc
		// through which we get session object, without this we wont be able to communicate with database
		   if ( sessionFactory == null ) {
	            try {
	                // load hibernate.cfg.xml and build 
	            	// we need to follow these levels for security purpose 
	                standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
	                // once registry is created
	                MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
	                
	                Metadata metadata = metadataSources.getMetadataBuilder().build();
	                // session is the starting point which is created using sessionFactory 
	                sessionFactory = metadata.getSessionFactoryBuilder().build();
	            }catch ( Exception e) {
	                e.printStackTrace();
	                
	                if ( standardServiceRegistry != null ) {
	                    StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
	                }
	            }
	        }
	        return sessionFactory;
	    }

}
