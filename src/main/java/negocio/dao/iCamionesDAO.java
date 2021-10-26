package negocio.dao;

import java.util.ArrayList;

public interface iCamionesDAO<Camiones> extends iDAO<Camiones> {

	@Override
	public ArrayList<Camiones> getLista();

	@Override
	public Camiones findId(long l);

	@Override
	public boolean deleteById(long l);

}
