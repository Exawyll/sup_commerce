package fr.imie.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcommerce.dao.DaoFactory;
import fr.imie.supcommerce.entity.Category;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/removeCategory")
public class RemoveCategoryServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Long id = Long.parseLong(req.getParameter("id"));
		
		Category c = new Category();
		c = DaoFactory.getCategoryDao().findById(id);
		
		if (c != null) {
			DaoFactory.getCategoryDao().deleteCategory(c);
		}
		
		resp.sendRedirect("/SupCommerce/views/category/listCategory.jsp");
	}

	
}
