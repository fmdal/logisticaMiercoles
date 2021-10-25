package negocio.dominio;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Users {

	protected int user_ID;
	protected String contrasenia;
	protected String nombre;
	protected String apellido;
	protected Calendar fecha_nac;
	protected String telefono;
	protected boolean perfil;

	public Users() {
	}

	public Users(int user_ID, String contrasenia, String nombre, String apellido, Calendar fecha_nac, String telefono,
			boolean perfil) {

		this.user_ID = user_ID;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nac = fecha_nac;
		this.telefono = telefono;
	}

	public int getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Calendar getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Calendar fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isPerfil() {
		return perfil;
	}

	public void setPerfil(boolean perfil) {
		this.perfil = perfil;
	}
}
