package negocio.dao.factory;

import negocio.dao.iViajesDAO;
import negocio.dao.implementacion.ViajesImplementacion;
import negocio.dominio.Viajes;

public class ViajesFactory {

	@SuppressWarnings("unchecked")
	public static iViajesDAO<Viajes> getImplementation(String source) {
		if (source.equals("DB")) {
			return (iViajesDAO<Viajes>) new ViajesImplementacion();
		}

		return null;
	}
}
