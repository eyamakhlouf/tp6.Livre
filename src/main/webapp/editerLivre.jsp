<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Modification des Livres</div>
			<div class="card-body">
				<form action="update.do" method="post">
					<div hidden class="form-group">

						<label class="control-label">ID Livre :</label> <input type="text"
							name="id" class="form-control" value="${Livre.idLivre}" />
					</div>

					<div class="form-group">
						<label class="control-label">Titre Livre :</label> <input
							type="text" name="titreLivre" class="form-control"
							value="${Livre.titreLivre}" />
					</div>

					<div class="form-group">
						<label class="control-label">Auteur de Livre :</label> <input
							type="text" name="auteur" class="form-control"
							value="${Livre.auteur}" />
					</div>

					<div class="form-group">
						<label class="control-label">Prix :</label> <input type="number"
							name="prix" class="form-control" value="${Livre.prix}" />
					</div>

			

					<div class="form-group">
						<label class="control-label">Nomre de pages de Livre :</label> <input
							type="number" name="nbpages" class="form-control"
							value="${Livre.nbpages}" />
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Modifier</button>
					</div>
						<div class="form-group">
						<select name="genre" class="form-control">
							<option value="${Livre.genre.idgenre}" selected>${Livre.genre.nomgenre}</option>
							<c:forEach items="${colModel.genres}" var="col">
								<c:if test="${col.idgenre != livre.genres.idgenre}">
									<option value="${col.idgenre}">${col.nomgenre}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>