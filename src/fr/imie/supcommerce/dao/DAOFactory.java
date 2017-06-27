/**
 * 
 */
package fr.imie.supcommerce.dao;

import fr.imie.supcommerce.dao.jpa.JpaCategoryDao;
import fr.imie.supcommerce.dao.jpa.JpaProductDao;
import fr.imie.supcommerce.util.PersistenceManager;

/**
 * @author WYLLIAM
 *
 */
public class DaoFactory {
	
	//Private constructor prevent instantiation
	private DaoFactory() {
    }

    public static ProductDao getProductDao() {
        return new JpaProductDao(PersistenceManager.getEntityManagerFactory());
    }

    public static CategoryDao getCategoryDao() {
        return new JpaCategoryDao(PersistenceManager.getEntityManagerFactory());
    }
}
