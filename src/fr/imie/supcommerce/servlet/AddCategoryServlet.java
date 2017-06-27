package fr.imie.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcommerce.dao.DaoFactory;
import fr.imie.supcommerce.entity.Category;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/addCategory")
public class AddCategoryServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = 
				req.getRequestDispatcher("/views/auth/addCategory.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Create a new Category object
		Category cat = new Category();
		// Retrieve the form parameters
		// Set the parameters in the object
		cat.setName(req.getParameter("name"));
		
		DaoFactory.getCategoryDao().insertCategory(cat);
		
		resp.sendRedirect("/SupCommerce/listCategory");
	}
	
	
}
