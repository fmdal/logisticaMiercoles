package negocio.dominio;

public class Camiones {
	
	protected int camion_ID;
	protected String patente;
	protected String marca;
	protected String modelo;
	protected int tanque_nafta;
	protected int peso_max;
	protected double litrosxkm;
	protected boolean disponible;

	public Camiones () {}
	
	public Camiones (int camion_ID, String patente, String marca, String modelo, int tanque_nafta, int peso_max, double litrosxkm, boolean disponible) {
		this.camion_ID = camion_ID;
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.tanque_nafta = tanque_nafta;
		this.peso_max = peso_max;
		this.litrosxkm = litrosxkm;
		this.disponible = disponible;
	}
	
	public int getCamion_ID() {
		return camion_ID;
	}

	public void setCamionID(int camion_ID) {
		this.camion_ID = camion_ID;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getTanque_nafta() {
		return tanque_nafta;
	}

	public void setTanque_nafta(int tanque_nafta) {
		this.tanque_nafta = tanque_nafta;
	}

	public int getPeso_max() {
		return peso_max;
	}

	public void setPeso_max(int peso_max) {
		this.peso_max = peso_max;
	}

	public double getLitrosxkm() {
		return litrosxkm;
	}

	public void setLitrosxKm(double litrosxkm) {
		this.litrosxkm = litrosxkm;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}	
}