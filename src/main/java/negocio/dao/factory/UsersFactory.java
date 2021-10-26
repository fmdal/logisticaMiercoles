package negocio.dao.factory;

import negocio.dao.iUsersDAO;
import negocio.dao.implementacion.UsersImplementacion;
import negocio.dominio.Users;

public class UsersFactory {

	@SuppressWarnings("unchecked")
	public static iUsersDAO<Users> getImplementation(String source) {
		if (source.equals("DB")) {
			return (iUsersDAO<Users>) new UsersImplementacion();
		}

		return null;
	}
}
