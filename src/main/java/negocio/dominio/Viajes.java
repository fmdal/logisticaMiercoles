package negocio.dominio;

public class Viajes {

	protected int viajes_ID;
	protected Choferes chofer;
	protected Camiones camion;
	protected float consumo_nafta;
	protected String origen;
	protected String destino;
	protected double distancia; 
	
	public Viajes () {}
	
	public Viajes (int viajesID, Choferes chofer, Camiones camion, float consumo_nafta, String origen, String destino, double distancia) {
		this.viajes_ID = viajes_ID;
		this.chofer = chofer;
		this.consumo_nafta = consumo_nafta;
		this.origen = origen;
		this.destino = destino;
		this.distancia = distancia;
	}
	
	public int getViajes_ID() {
		return viajes_ID;
	}

	public void setViajes_ID(int viajes_ID) {
		this.viajes_ID = viajes_ID;
	}

	public Choferes getChofer() {
		return chofer;
	}

	public void setChofer(Choferes chofer) {
		this.chofer = chofer;
	}

	public Camiones getCamion() {
		return camion;
	}

	public void setCamion(Camiones camion) {
		this.camion = camion;
	}

	public float getConsumo_nafta() {
		return consumo_nafta;
	}

	public void setConsumo_nafta(float consumo_nafta) {
		this.consumo_nafta = consumo_nafta;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

}
