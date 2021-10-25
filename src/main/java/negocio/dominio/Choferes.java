package negocio.dominio;

import java.util.ArrayList;
import java.util.Calendar;

public class Choferes extends Users {

	protected long choferID;
	protected String categoria;
	protected ArrayList<Camiones> lista_camiones = new ArrayList<Camiones>();

	public Choferes() {
	}

	public Choferes(int user_ID, String contrasenia, String nombre, String apellido, Calendar fecha_nac,
			String telefono, boolean perfil, long chofer, String categoria, ArrayList<Camiones> lista_camiones) {

		super();
		this.user_ID = user_ID;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nac = fecha_nac;
		this.telefono = telefono;
		this.categoria = categoria;
		this.lista_camiones = lista_camiones;
	}

	public long getChoferID() {
		return choferID;
	}

	public void setChoferID(long choferID) {
		this.choferID = choferID;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public ArrayList<Camiones> getLista_camiones() {
		return lista_camiones;
	}

	public void setLista_camiones(ArrayList<Camiones> lista_camiones) {
		this.lista_camiones = lista_camiones;
	}

}
