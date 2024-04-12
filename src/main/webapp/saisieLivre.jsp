<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Saisie des Livres</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="header.jsp" %>
    
    <div class="container">
        <div class="card">
            <div class="card-header">
                Saisie des Livres
            </div>
            <div class="card-body">
                <form action="save.do" method="post">
                        <div class="form-group">
                        <label class="control-label">id Livre :</label>
                        <input type="text" name="idLivre" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Nom Livre :</label>
                        <input type="text" name="titreLivre" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Auteur de Livre :</label>
                        <input type="text" name="auteur" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Prix :</label>
                        <input type="number" name="prix" class="form-control"/>
                    </div>
               
                    <div class="form-group">
                        <label class="control-label">Nombre de pages :</label>
                        <input type="number" name="nbpages" class="form-control"/>
                    </div>
                  
                    	<div class="form-group">
					  <label class="control-label">Nom Genre </label>
						<select name="genre" class="form-control">
							<c:forEach items="${colModel.genres}" var="col">
								<option value="${col.idgenre}">${col.nomgenre}</option>
							</c:forEach>
						</select>
					</div>
					 <div class="form-group">
                    <button type="submit" class="btn btn-primary">Ajouter</button></div>
                </form>
                
                
            </div>
             
        </div>
    </div>
                            
    
</body>
</html>