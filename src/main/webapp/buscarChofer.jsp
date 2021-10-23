<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="container" style="padding: 20px">
	<form method="post" action="ChoferesController">

		<div style="text-align: left;">
			<label>DNI del chofer</label>
			<input type="text" id="userID" name="userID" required="required" />
		</div>


		

		<input id="accion" name="accion" type="hidden" value="alta">

		<div style="text-align: left; padding: 30px;">
			<button type="submit" class="btn btn-light">Buscar</button>
			<button class="btn btn-dark" onclick="window.location.href='http://localhost:8080/AvanzadaSeg/bajaCamion.jsp'">Volver</button>
		</div>



		<input id="accion" name="accion" type="hidden" value="baja">

		<div style="text-align: left; padding: 30px;">
			<button type="submit" class="btn btn-light">Volver</button>
			<button class="btn btn-dark" onclick="window.location.href='http://localhost:8080/AvanzadaSeg/perfilAdmin.jsp'">Volver</button>
		</div>

	</form>
</div>

<jsp:include page="footer.html"></jsp:include>