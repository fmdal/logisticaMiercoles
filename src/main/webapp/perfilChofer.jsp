<%@page import="java.util.*"%>
<%@page import="negocio.dao.iDAO"%>
<%@page import="negocio.dao.factory.ViajesFactory"%>
<%@page import="negocio.dominio.Viajes"%>

<%-- <% --%>
// iDAO<Viajes> viajesDAO = ViajesFactory.getImplementation("DB");

// ArrayList<Viajes> viajes = viajesDAO.getLista();
<%-- %> --%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="container" style="padding: 20px">
	<form method="post" action="">
		<div style="text-align: left;">
			<label>Patente</label> <input type="text" id="patente" name="patente" required="required" />
		</div>

		<div style="text-align: left;">
			<label>Viaje1</label>
			<p style="text-align: center;">
				<button type="submit" class="btn btn-light">Finalizar</button>
			</p>
		</div>
		<%-- 
<form method="GET" action="ViajesController">
	<td id="viajesID" name="viajesID">ID</td>
		<% for (int i=0;i<ViajesController.get().get().size(); i++ ){ %>
	<td><%= sl.get().get().get(i).getIdViaje()  %></td>
	<td><%= sl.get().get().get(i).getDestino()  %></td>
<%} %>
</form>
--%>
		<table>
		<tr><td>Id del viaje</td><td>Patente</td><td>Trayecto</td><td>Finalizar</td></tr>
<%-- 			<% --%>
// 			for (Viajes viaje : viajes) {
<%-- 			%> --%>
<!-- 			<tr><td>12</td><td>XCV123</td><td>La Plata - Mendoza</td><td><button class="btn btn-light">terminar</button></td></tr> -->
<%-- 			<%-- <tr><td><%=viaje.get()%></td><td><%=viaje.getId()%></td><td><%=viaje.getId()%></td><td></td></tr> --%> --%>
<%-- 			<% --%>
// 			}
<%-- 			%> --%>
		</table>

		<p style="text-align: left;">
			<button type="submit" class="btn btn-light">Ingresar</button>
		</p>

		<a type="button" class="btn btn-dark" href="http://localhost:8080/AvanzadaSeg/perfilAdmin.jsp">Volver</a>



	</form>
</div>

<jsp:include page="footer.html"></jsp:include>