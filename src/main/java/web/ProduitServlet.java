package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Produits;
import dao.ProduitDao;

/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/")
public class ProduitServlet extends HttpServlet {
	private ProduitDao produitDAO;

    public void init() {
    	produitDAO = new ProduitDao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        String action = request.getServletPath();

    	        try {
    	            switch (action) {
    	                case "/insert":
    	                    insertUser(request, response);
    	                    break;
    	                default:
    	                  
    	                    break;
    	            }
    	        } catch (SQLException ex) {
    	            throw new ServletException(ex);
    	        }
    	    }
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException {
    	        String name = request.getParameter("name");
    	        String email = request.getParameter("email");
    	        String country = request.getParameter("country");
    	        User newUser = new User(name, email, country);
    	        userDAO.insertUser(newUser);
    	        response.sendRedirect("list");
    	    }



	

}
