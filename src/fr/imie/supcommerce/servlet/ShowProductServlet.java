package fr.imie.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcommerce.dao.DaoFactory;
import fr.imie.supcommerce.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/showProduct")
public class ShowProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		Product p = DaoFactory.getProductDao().findById(id);
		
		req.setAttribute("p", p);
		
		if (p != null) {
			RequestDispatcher rd = 
					req.getRequestDispatcher("/views/product/showProduct.jsp");
			rd.forward(req, resp);
		} else {
			resp.getWriter().println("No product with id " + id);
		}
		
		
	}
	
}
