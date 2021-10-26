package negocio.dao.factory;

import negocio.dao.iCamionesDAO;
import negocio.dao.implementacion.CamionesImplementacion;
import negocio.dominio.Camiones;

public class CamionesFactory {

	@SuppressWarnings("unchecked")
	public static iCamionesDAO<Camiones> getImplementation(String source) {
		if (source.equals("DB")) {
			return (iCamionesDAO<Camiones>) new CamionesImplementacion();
		}

		return null;
	}
}
