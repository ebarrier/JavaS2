package factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateEngine {

	private static final SessionFactory sessionFactory;

	static {
	      final Configuration config = new Configuration();
	      config.configure("/resources/hibernate.cfg.xml");
	      sessionFactory = config.buildSessionFactory();
	   }
	   public static SessionFactory getInstance() {
	      return sessionFactory;
	   }
	
}
