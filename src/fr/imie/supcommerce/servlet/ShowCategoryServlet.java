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
@WebServlet(urlPatterns = "/showCategory")
public class ShowCategoryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		Category c = DaoFactory.getCategoryDao().findById(id);
		
		req.setAttribute("c", c);
		
		if (c != null) {
			RequestDispatcher rd = 
					req.getRequestDispatcher("/views/category/showCategory.jsp");
			rd.forward(req, resp);
		} else {
			resp.getWriter().println("No product with id " + id);
		}
	}
}
