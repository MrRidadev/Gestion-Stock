package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
    @Override
    	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		
    	doGet(req,resp);
    	}
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        String action = request.getServletPath();

    	        try {
    	            switch (action) {
    	                case "/insert":
    	                	insertProduit(request, response);
    	                    break;
    	               
    	                case "/Ajouter" : 
    	                	Ajouter(request,response);
    	                	
    	                	break;
    	                	
    	                default:
    	                	listProduit(request, response);
    	                    break;
    	            }
    	        } catch (SQLException ex) {
    	            throw new ServletException(ex);
    	        }
    	    }
    private void insertProduit(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException {
    	
    	
    	        String nom = request.getParameter("nom");
    	        String description = request.getParameter("desc");
    	        int quantite = Integer.parseInt(request.getParameter("stock"));
    	        int prix = Integer.parseInt(request.getParameter("prix"));
    	        String categorie = request.getParameter("category");
    	        Produits prmodel = new Produits(nom, description, quantite, prix, categorie);
    	        System.out.println(prmodel);
    	        produitDAO.insertProduit(prmodel);
    	        response.sendRedirect("list");
    	       

    	    }
    private void Ajouter(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException {
    	        response.sendRedirect("./form.jsp");
    	    }
    private void listProduit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
                List < Produits > listProduit =produitDAO.selectAllProduits();
                request.setAttribute("listProduit", listProduit);
                RequestDispatcher dispatcher = request.getRequestDispatcher("gestion.jsp");
                dispatcher.forward(request, response);

            }


	

}
