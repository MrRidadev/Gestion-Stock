package web;

import java.io.IOException;
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
    private static final long serialVersionUID = 1L;
    private ProduitDao produitDao;

    /**
     * Constructeur : initialise le DAO
     */
    public ProduitServlet() {
        this.produitDao = new ProduitDao();
    }

    /**
     * Gère les requêtes GET
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/Ajouter":
                ajouterProduit(request, response);
                break;
            default:
                response.sendRedirect("index.jsp"); // Redirection vers la page principale
                break;
        }
    }

    /**
     * Redirige vers le formulaire d'ajout de produit
     */
    private void ajouterProduit(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("form.jsp").forward(request, response);
    }

    /**
     * Gère les requêtes POST pour ajouter un produit
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Récupération des données du formulaire
        String nom = request.getParameter("nome");
        String description = request.getParameter("desc");
        int quantite = Integer.parseInt(request.getParameter("stock"));
        int prixUnitaire = Integer.parseInt(request.getParameter("prix"));
        String categorie = request.getParameter("inputCat");

        // Création d'un objet Produit
        Produits produit = new Produits(0, nom, description, quantite, prixUnitaire, categorie);

        try {
            // Insertion dans la base de données via ProduitDao
            produitDao.insertProduit(produit);
            
            // Redirection après l'ajout
            response.sendRedirect("index.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Erreur lors de l'ajout du produit", e);
        }
    }
}
