<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion Stock</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="container">

<a type="button" class="btn btn-success" href="Ajouter">Ajouter Produit</a>

<h1>List Des Produits</h1>

<table  class="table table-striped">
    <thead  class="thead">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Nom du produit</th>
        <th scope="col">Quantité</th>
        <th scope="col">Prix</th>
        <th scope="col">Catégorie</th>
        <th scope="col">Action</th>

    </tr>
    </thead>
    <tbody>
     <c:forEach var="produit" items="${listProduit}">
                                <tr>
                                    <td>
                                        <c:out value="${produit.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${produit.nomProduit}" />
                                    </td>
                                    
                                   <td> 
                                        <c:out value="${produit.quantite}" />
                                    </td>
                                    <td>
                                        <c:out value="${produit.prixUnitaire}" />
                                    </td>
                                   <td>
                                        <c:out value="${produit.categorie}" />
                                    </td>
                                    <td>
                                    <a herf="delete?id=<c:out value='${produit.id}' />" class="btn btn-danger" >Supprimer</a>
                                    <a herf="delete?id=<c:out value='${produit.id}' />" class="btn btn-warning" >modifier</a>
                                    
                                    </td>
                                          
                               

                                </tr>
                              
                              
                              
                            </c:forEach>
    </tbody>
</table>
</body>
</html>