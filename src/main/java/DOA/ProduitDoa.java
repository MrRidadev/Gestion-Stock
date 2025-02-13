package DOA;

public class ProduitDoa {
	private String jdbcURL = "jdbc:mysql://localhost:3306/MyDb?useSSL=false";
	private String jdbcUsername ="root";
	private String jdbcPassWord ="0000";
	
	private static String INSERT_USER_SQL = "INSERT INTO mydb"+"(id,NomProduit,Dscription,Quantité,PrixUnitaire,Catégorie)"
	+"?,?,?,?,?,?";
	
	private static final String SELECT_PRODUITS_BY_ID= "select id,NomProduit,Dscription,Quantité,PrixUnitaire,Catégorie";
	private static final String SELECTT_ALL_PRODUITS= "select * from Produits";
	private static final String DELETE_PRODUITS ="delete  from produits where id=?";
	private static final String UPDATE_PRODUITS ="update produits set NomProduit=?,Dscription=?,Quantité=?,PrixUnitaire=?,"
			+ "Catégorie=? where id=?;";
	
}
