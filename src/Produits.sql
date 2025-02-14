create database MyDb;
use MyDb;

create table Produits (
id int primary key auto_increment ,
NomProduit varchar(200),
Dscription varchar(255),
Quantité int,
PrixUnitaire int ,
Catégorie varchar(255)
);


