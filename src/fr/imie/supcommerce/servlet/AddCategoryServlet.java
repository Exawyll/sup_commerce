package fr.imie.supcommerce.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcommerce.entity.Category;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/addCategory")
public class AddCategoryServlet extends HttpServlet{
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction t;
	
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		emf = Persistence.createEntityManagerFactory("My-PU");
		em = emf.createEntityManager();
		t = em.getTransaction();
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		em.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = 
				req.getRequestDispatcher("/auth/addCategory.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Create a new Category object
		Category cat = new Category();
		// Retrieve the form parameters
		// Set the parameters in the object
		cat.setName(req.getParameter("name"));
		
		// Use an EntityManager to persist the object
		try {
			t.begin();
			
			em.persist(cat);
			
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			destroy();
		}
	}
	
	
}
