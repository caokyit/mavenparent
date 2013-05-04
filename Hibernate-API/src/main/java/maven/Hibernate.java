package maven;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




/**
 * Class to manage hibernate instance.
 * @author Ginji
 *
 */
public class Hibernate {

	private static final SessionFactory SESSIONFACTORY = buildSessionFactory();
	/**
	 * build a session factory.
	 * @return SessionFactory
	 */
	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ptex) {
			// Make sure you log the exception, as it might be swallowed
			throw new ExceptionInInitializerError(ptex);
		}
	}
	/**
	 * public the session factory.
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSIONFACTORY;
	}
	/**
	 * close the session factory.
	 */
	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}

