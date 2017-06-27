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
import fr.imie.supcommerce.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/listProduct")
public class ListProductServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// get all products from database
		List<Product> products = DaoFactory.getProductDao().findAll();
		
		req.setAttribute("products", products);
		
		RequestDispatcher rd = 
				req.getRequestDispatcher("/views/product/listProduct.jsp");
		rd.forward(req, resp);
		
	}
}
