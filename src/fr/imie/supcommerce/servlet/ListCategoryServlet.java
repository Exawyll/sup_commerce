/**
 * 
 */
package fr.imie.supcommerce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcommerce.dao.DaoFactory;
import fr.imie.supcommerce.entity.Category;

/**
 * @author WYLLIAM
 *
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/listCategory")
public class ListCategoryServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get all products from database
				List<Category> categories = DaoFactory.getCategoryDao().findAll();
				
				req.setAttribute("categories", categories);
				
				RequestDispatcher rd = 
						req.getRequestDispatcher("/views/category/listCategory.jsp");
				rd.forward(req, resp);
	}
	
	
}
