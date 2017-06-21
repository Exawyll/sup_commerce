package fr.imie.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.supcommerce.dao.ProductDao;
import fr.imie.supcommerce.model.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/showProduct")
public class ShowProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		Product p = ProductDao.findProduct(id);
		
		req.setAttribute("p", p);
		
		if (p != null) {
			RequestDispatcher rd = 
					req.getRequestDispatcher("/showProduct.jsp");
			rd.forward(req, resp);
		} else {
			resp.getWriter().println("No product with id " + id);
		}
		
		
	}
	
}
