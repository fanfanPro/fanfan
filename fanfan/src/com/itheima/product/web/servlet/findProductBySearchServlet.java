package com.itheima.product.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.product.domain.PageBean;
import com.itheima.product.domain.Product;
import com.itheima.product.service.ProductService;

/**
 * Servlet implementation class findProductBySearchServlet
 */
@WebServlet("/findProductBySearchServlet")
public class findProductBySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findProductBySearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");  //只能解决POST方式的乱码
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		ProductService ps = new ProductService();
		List<Product> pb = ps.findProductBySearch(name);
		
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/product_search_list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
