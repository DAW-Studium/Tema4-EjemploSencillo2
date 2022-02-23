<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true" import="java.util.*"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>ToDo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12 mt-5">
				<h1 class="text-center">Mis tareas pendientes</h1>
				<form action="ServletTareas" method="post">
					<label class="form-label">Tarea</label> <input class="form-control"
						type="text" name="tarea" placeholder="Tarea" autofocus
						required="required" /> <input class="btn btn-primary mt-3"
						type="submit" value="Enviar" /> <input
						class="btn btn-primary mt-3" type="reset" value="Limpiar" />
				</form>
				<div class="my-3">
					<h2 class="text-center">Listado de tareas pendientes</h2>
					<%
					// Chequea el contenido de la lista en la sesión
					ArrayList<String> lista = (ArrayList<String>) session.getAttribute("lista");
					if (lista != null && lista.size() > 0) {
					%>
					<table border="1" cellspacing="0" cellpadding="5">
						<tr>
							<th>Tarea</th>
							<th>Editar</th>
							<th>Finalizada</th>
						</tr>
						<%
						//Muestra las tareas de la lista
						for (int i = 0; i < lista.size(); i++) {
							String tarea = lista.get(i);
						%>
						<tr>
							<td><%=tarea%></td>
							<td></td>
							<td></td>
						</tr>
						<%
						}
						%>
					</table>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
<!-- Script para evitar el reenvio de información -->
<script type="text/javascript">
if (window.history.replaceState) { // verificamos disponibilidad
    window.history.replaceState(null, null, window.location.href);
}
</script>
</html>