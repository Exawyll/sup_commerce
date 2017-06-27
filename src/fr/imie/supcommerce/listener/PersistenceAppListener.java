package fr.imie.supcommerce.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import fr.imie.supcommerce.util.PersistenceManager;

public class PersistenceAppListener implements ServletContextListener {

	// Call on application destruction
	@Override
	public void contextDestroyed(ServletContextEvent evt) {
		PersistenceManager.closeEntityManagerFactory();
	}

	// Call on application initialization
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
	}
}

