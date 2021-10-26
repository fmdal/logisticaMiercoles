package negocio.dao.factory;

import negocio.dao.iChoferesDAO;
import negocio.dao.implementacion.ChoferesImplementacion;
import negocio.dominio.Choferes;

public class ChoferesFactory {

	@SuppressWarnings("unchecked")
	public static iChoferesDAO<Choferes> getImplementation(String source) {
		if (source.equals("DB")) {
			return (iChoferesDAO<Choferes>) new ChoferesImplementacion();
		}

		return null;
	}
}
