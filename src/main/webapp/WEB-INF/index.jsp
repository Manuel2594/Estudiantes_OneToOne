<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todos los Estudiantes</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>

	<h1>Todos los estudiantes</h1>

	<a href="/estudiante/new"> Agregar nuevo estudiante</a>
	<br>
	<a href="/contacto/new"> Nuevo Contacto</a>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Edad</th>
				<th>direccion</th>
				<th>ciudad</th>
				<th>estado</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="estudiante">
				<tr>
					<td>${estudiante.nombre }</td>
					<td>${estudiante.edad}</td>
					<td>${estudiante.getContacto().getDireccion()}</td>
					<td>${estudiante.getContacto().getCiudad()}</td>
					<td>${estudiante.getContacto().getEstado()}</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

</body>
</html>