package negocio.dao;

import java.util.ArrayList;

public interface iCamionesDAO<T> {

	public boolean add(T elemento);

	public ArrayList<T> getLista();

	public T findId(long l);

	public boolean deleteById(long l);

	public boolean save(T elemento);
}
