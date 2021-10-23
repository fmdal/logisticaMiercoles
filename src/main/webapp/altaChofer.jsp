<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="container" style="padding: 20px">
	<form method="post" action="ChoferesController">

		<div style="text-align: left;">
			<label>DNI</label>
			<input type="text" id="userID" name="userID" required="required" />
		</div>
		
				<div style="text-align: center;">
			<br /> <label>Contraseña</label>
			<input type="password" id="pass" name="pass" required="required" />
		</div>

		<div style="text-align: left;">
			<label>Nombre</label>
			<input type="text" id="nombre" name="nombre" required="required" />
		</div>

		<div style="text-align: left;">
			<label>Apellido</label>
			<input type="text" id="apellido" name="apellido" required="required" />
		</div>
		
		<div style="text-align: left;">
			<label>Fecha de nacimiento</label>
			<input type="text" id="fechaNac" name="fechaNac" required="required" />
		</div>

		<div style="text-align: left;">
			<label>Telefono</label>
			<input type="text" id="telefono" name="telefono" required="required" />
		</div>
	
			<div style="text-align: left;">
			<label>Categoria</label>
			<input type="text" id="litrosxKm" name="litrosxKm" required="required" />
		</div>
		
					<div style="text-align: left;">
			<label>Lista de Camiones</label>
			<input type="text" id="listaCamiones" name="listaCamiones" required="required" />
		</div>
		

		<input id="accion" name="accion" type="hidden" value="alta">

		<div style="text-align: left; padding: 30px;">
			<button type="submit" class="btn btn-light">Ingresar</button>
			<button class="btn btn-dark" onclick="window.location.href='http://localhost:8080/AvanzadaSeg/perfilAdmin.jsp'">Volver</button>
		</div>

	</form>
</div>

<jsp:include page="footer.html"></jsp:include>