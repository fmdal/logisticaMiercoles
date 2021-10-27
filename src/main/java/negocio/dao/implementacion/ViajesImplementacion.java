package negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.Conexion;
import negocio.dao.iViajesDAO;
import negocio.dominio.Viajes;

public class ViajesImplementacion implements iViajesDAO<Viajes> {

	@Override
	public boolean add(Viajes elemento) {

		String sql = "INSERT INTO viajes(viajesID, chofer, camion, consumoNafta, trayecto) VALUES (?,?,?,?,?)";

		try {
			Connection con = Conexion.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, elemento.getViajes_ID());
//				ps.setString(2, elemento.getChofer());
//				ps.setString(3, elemento.getCamion());
			ps.setDouble(4, elemento.getConsumo_nafta());

			ps.execute();

			ps.close();

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public ArrayList<Viajes> getLista() {

		ArrayList<Viajes> lista_viajes = new ArrayList<>();

		Connection con = null;
		PreparedStatement prep = null;

		try {
			con = Conexion.getConnection();
			prep = con.prepareStatement("SELECT * FROM listaViajes");

			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				Viajes viaje = new Viajes();

				viaje.setViajes_ID(rs.getInt("viajes_ID"));
//					viaje.setChofer((Choferes) rs).getChofer("chofer");
//					viaje.setCamion((Camiones) rs).getCamion("camion"); //no se bien como es esto
				viaje.setConsumo_nafta(rs.getInt("consumo_nafta"));
				viaje.setOrigen(rs.getString("origen"));
				viaje.setDestino(rs.getString("destino"));
				viaje.setDistancia(rs.getDouble("distancia"));

				lista_viajes.add(viaje);
			}
			prep.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista_viajes;
	}

	@Override
	public Viajes findId(long l) {

		Connection con = null;
		PreparedStatement prep = null;

		try {
			String sql = "SELECT * FROM viajes WHERE id=?";

			con = Conexion.getConnection();
			prep = con.prepareStatement(sql);

			int id = 0; // aca no se si rinde inicializar
			prep.setInt(1, id);

			ResultSet rs = prep.executeQuery();

			Viajes viaje = new Viajes();

			if (rs.next()) {
				viaje.setViajes_ID(rs.getInt("viajes_ID"));
				viaje.setConsumo_nafta(rs.getInt("consumo_nafta"));
				viaje.setOrigen(rs.getString("origen"));
				viaje.setDestino(rs.getString("destino"));
				viaje.setDistancia(rs.getDouble("distancia"));

				viaje.add(viaje); // cree el metodo, en dominio Viajes, pero esta vacia
			}
			return viaje;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteById(long l) {

		String sql = "UPDATE viajes SET activo=0 WHERE viajesID=?";

		try {
			Connection con = Conexion.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setLong(1, l);

			ps.execute();

			ps.close();

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean save(Viajes elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCamionId(int id) {

		Connection con = null;
		PreparedStatement prep = null;

		try {
			String sql = "SELECT * FROM viajes WHERE id=?";

			con = Conexion.getConnection();
			prep = con.prepareStatement(sql);

			prep.setInt(1, id);

			ResultSet rs = prep.executeQuery();

			if (rs.next()) {
				return rs.getInt("camion");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

}
