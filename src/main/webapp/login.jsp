<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="container" style="padding: 20px">
	<form method="post" action="UsersController">
		<div style="text-align: center;">
			<label>DNI</label>
			<input type="text" id="user" name="user" required="required" />
		</div>
		<div style="text-align: center;">
			<br /> <label>Contrase�a</label>
			<input type="password" id="pass" name="pass" required="required" />
		</div>

		<input id="accion" name="accion" type="hidden" value="login">
		
		<p style="text-align: center;">
			<button type="submit" class="btn btn-primary">Ingresar</button>
		</p>
	</form>
</div>

<jsp:include page="footer.html"></jsp:include>