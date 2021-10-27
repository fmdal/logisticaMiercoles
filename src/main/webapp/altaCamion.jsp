<%-- <jsp:include page="header.jsp"></jsp:include> asd--%>
<jsp:include page="navbar.jsp"></jsp:include>
//
<div class="container" style="padding: 20px">
	<form method="post" action="CamionesController">

		<div style="text-align: left;">
			<label>Patente</label>
			<input type="text" id="patente" name="patente" required="required" />
		</div>

		<div style="text-align: left;">
			<label>Marca</label>
			<input type="text" id="marca" name="marca" required="required" />
		</div>

		<div style="text-align: left;">
			<label>Modelo</label>
			<input type="text" id="modelo" name="modelo" required="required" />
		</div>

		<div style="text-align: left;">
			<label>Capacidad del tanque de nafta</label>
			<input type="number" id="tanqueNafta" name="tanqueNafta" required="required" />
		</div>

		<div style="text-align: left;">
			<label>Peso maximo</label>
			<input type="number" id="pesoMax" name="pesoMax" required="required" />
		</div>

		<div style="text-align: left;">
			<label>Consumo de litros de nafta por kilometro</label>
			<input type="number" id="litrosxKm" name="litrosxKm" required="required" />
		</div>
		

		<input id="accion" name="accion" type="hidden" value="alta">

		<div style="text-align: left; padding: 30px;">
			<button type="submit" class="btn btn-light">Ingresar</button>
			<button class="btn btn-dark" onclick="window.location.href='http://localhost:8080/AvanzadaSeg/perfilAdmin.jsp'">Volver</button>
		</div>

	</form>
</div>

<jsp:include page="footer.html"></jsp:include>