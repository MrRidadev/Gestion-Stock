<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion Stock</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="container">
<h1>Ajouter Produit</h1>
<form class="p-4">
    <div class="form-group">
        <label for="nome">Nom du produit</label>
        <input type="text" class="form-control" id="nome" aria-describedby="emailHelp" placeholder="Enter Nom du produit">
    </div>
    <div class="form-group">
        <label for="desc">Description</label>
        <input type="text" class="form-control" id="desc" placeholder="Description">
    </div>


    <div class="form-group">
        <label for="stock">Quantité en stock</label>
        <input type="number" class="form-control" id="stock" placeholder="Quantité en stock">
    </div>

    <div class="form-group">
        <label for="prix">Prix unitaire</label>
        <input type="number" class="form-control" id="prix" placeholder="Prix unitaire">
    </div>

    <div class="form-group col-md-4">
        <label for="inputCat">Catégorie du produit</label>
        <select id="inputCat" class="form-control">
            <option selected disabled>Choose...</option>
            <option>Électronique</option>
            <option>Vêtements</option>
            <option>Alimentation</option>

        </select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

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
    <tr>
        <th scope="row">1</th>
        <td>Frommage</td>
        <td>12ps</td>
        <td>140dh</td>
        <td>Électronique</td>
        <td><button type="button" class="btn btn-danger">Supprimer</button>
<button type="button" class="btn btn-warning">Modifier</button></td>
    </tr>
    </tbody>
</table>
</body>
</html>