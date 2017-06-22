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
@WebServlet(urlPatterns = "/auth/addProduct")
public class AddProductServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = 
				req.getRequestDispatcher("/auth/addProduct.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product p = new Product();
		p.setName(req.getParameter("name"));
		p.setDescription(req.getParameter("description")); 
		p.setPrice(Float.parseFloat(req.getParameter("price")));
		
		Long id = ProductDao.addProduct(p);
		
		resp.sendRedirect("/SupCommerce/showProduct?id=" + id.toString());
	}
	
}
