<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formulaire</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form class="p-4" action="insert" method="post">
    <div class="form-group">
        <label for="nome">Nom du produit</label>
        <input type="text" class="form-control" id="nom" name="nom" aria-describedby="emailHelp" placeholder="Enter Nom du produit">
    </div>
    <div class="form-group">
        <label for="desc">Description</label>
        <input type="text" class="form-control" id="desc" name="desc" placeholder="Description">
    </div>


    <div class="form-group">
        <label for="stock">Quantité en stock</label>
        <input type="number" class="form-control" id="stock" name="stock" placeholder="Quantité en stock">
    </div>

    <div class="form-group">
        <label for="prix">Prix unitaire</label>
        <input type="number" class="form-control" name="prix" id="prix" placeholder="Prix unitaire">
    </div>

    <div class="form-group col-md-4">
        <label for="inputCat">Catégorie du produit</label>
        <select id="inputCat" name="category" class="form-control">
            <option selected disabled>Choose...</option>
            <option value="Electronique">Electronique</option>
            <option value="Vetements">Vetements</option>
            <option value="Alimentation">Alimentation</option>

        </select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>