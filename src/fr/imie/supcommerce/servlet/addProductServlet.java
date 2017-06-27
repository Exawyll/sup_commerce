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
import fr.imie.supcommerce.entity.Product;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/basicInsert")
public class AddProductServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> categories = DaoFactory.getCategoryDao().findAll();
		
		req.getSession().setAttribute("categories", categories);
		
		RequestDispatcher rd = 
				req.getRequestDispatcher("/views/auth/addProduct.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product p = new Product();
		p.setName(req.getParameter("name"));
		p.setDescription(req.getParameter("description")); 
		p.setPrice(Float.parseFloat(req.getParameter("price")));
		
		Category category = DaoFactory.getCategoryDao().findById(Long.parseLong(req.getParameter("category")));
		
		p.setCategory(category);
		
		Long id = DaoFactory.getProductDao().insertProduct(p);
		
		resp.sendRedirect("/SupCommerce/showProduct?id=" + id.toString());
	}
	
}
