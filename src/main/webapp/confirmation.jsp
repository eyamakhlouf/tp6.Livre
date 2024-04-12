<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation Ajout Livre</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="header.jsp" %>
    
    <div class="container">
        <div class="card">
            <div class="card-header">
                Confirmation Ajout Livre
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label class="control-label"> Titre livre :</label>
                    <input type="text" name="titreLivre" class="form-control" value="${Livre.titreLivre}"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Auteur :</label>
                    <input type="text" name="auteur" class="form-control" value="${Livre.auteur}"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Prix :</label>
                    <input type="number" name="prix" class="form-control" value="${Livre.prix}"/>
                </div>
              
                <div class="form-group">
                    <label class="control-label">Nombre de pages :</label>
                    <input type="number" name="nbpages" class="form-control" value="${Livre.nbpages}"/>
                </div>
            </div>
        </div>
    </div>
</body>
</html>