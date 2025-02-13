package Model;

public class Produits {
    private int id;
    private String nomProduit;
    private String description;
    private int quantite;
    private double prixUnitaire;
    private String categorie;

    // Constructeur 
    public Produits() {}

    // Constructeur avec paramètres
    public Produits(int id, String nomProduit, String description, int quantite, double prixUnitaire, String categorie) {
        this.id = id;
        this.nomProduit = nomProduit;
        this.description = description;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.categorie = categorie;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    // Méthode toString()
    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nomProduit='" + nomProduit + '\'' +
                ", description='" + description + '\'' +
                ", quantite=" + quantite +
                ", prixUnitaire=" + prixUnitaire +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}

