package dao; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Produits;

public class ProduitDao {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/MyDb?useSSL=false";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "0000";

    private static final String INSERT_PRODUIT_SQL = 
        "INSERT INTO Produits (id, NomProduit, Description, Quantite, PrixUnitaire, Categorie) VALUES (?, ?, ?, ?, ?, ?)";
    
    private static final String SELECT_PRODUITS_BY_ID = 
        "SELECT id, NomProduit, Description, Quantite, PrixUnitaire, Categorie FROM Produits WHERE id = ?";
    
    private static final String SELECT_ALL_PRODUITS = 
        "SELECT * FROM Produits";
    
    private static final String DELETE_PRODUIT = 
        "DELETE FROM Produits WHERE id = ?";
    
    private static final String UPDATE_PRODUIT = 
        "UPDATE Produits SET NomProduit = ?, Description = ?, Quantite = ?, PrixUnitaire = ?, Categorie = ? WHERE id = ?";
	private static final String UPDATE_PRODUIT_SQL = null;

    // Constructeur
    public ProduitDao() {}

    // Méthode pour obtenir la connexion à la base de données
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    //insert Produit 
    public void insertProduit(Produits produits) throws SQLException {
    	try(Connection connection = getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUIT_SQL)){
    			
    		preparedStatement.setString(1, produits.getNomProduit());
    		preparedStatement.setString(2, produits.getDescription());
    		preparedStatement.setInt(3, produits.getQuantite());
    		preparedStatement.setInt(4, (int) produits.getPrixUnitaire());
    		preparedStatement.setString(5, produits.getCategorie());
    		preparedStatement.executeLargeUpdate();
 
    }catch(Exception e) {
    	e.printStackTrace();
    }
}
    //update Produit
    public boolean insertUpdate(Produits produits, boolean rowUpdated) throws SQLException {
    	try(Connection connection = getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement( UPDATE_PRODUIT_SQL )){
    			
    		preparedStatement.setString(1, produits.getNomProduit());
    		preparedStatement.setString(2, produits.getDescription());
    		preparedStatement.setInt(3, produits.getQuantite());
    		preparedStatement.setInt(4, (int) produits.getPrixUnitaire());
    		preparedStatement.setString(5, produits.getCategorie());
    		preparedStatement.setInt(6, produits.getId());
    		PreparedStatement statement = null;
			rowUpdated = statement.executeUpdate() > 0;
 
    }
    	return rowUpdated;
}
    // select produit by id
    public Produits selectProduits(int id) {
    	Produits produits = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUITS_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            
         // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String NomProduit = rs.getString("NomProduit");
                String Dscription = rs.getString("Dscription");
                int Quantite = rs.getInt("Quantite");
                int PrixUnitaire = rs.getInt("PrixUnitaire");
                String Categorie = rs.getString("Categorie");
                
                produits = new Produits(id, NomProduit, Dscription, Quantite,PrixUnitaire,Categorie);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return produits;
    }

	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
		
	}
    
    }
