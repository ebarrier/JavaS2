package factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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

//	public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            // loads configuration and mappings
//            Configuration configuration = new Configuration().configure();
//            ServiceRegistry serviceRegistry
//                = new StandardServiceRegistryBuilder()
//                    .applySettings(configuration.getProperties()).build();
//             
//            // builds a session factory from the service registry
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
//        }
//         
//        return sessionFactory;
//    }
}
