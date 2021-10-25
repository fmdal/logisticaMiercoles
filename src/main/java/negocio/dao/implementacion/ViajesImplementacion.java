package negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.Conexion;
import negocio.dao.iDAO;
import negocio.dominio.Camiones;
import negocio.dominio.Choferes;
import negocio.dominio.Viajes;

public class ViajesImplementacion implements iDAO<Viajes> {

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
		public Object get(Object elemento) {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public boolean save() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean delete() {
			// TODO Auto-generated method stub
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

//// <<<<<<< HEAD
//		@Override
//		public Viajes findIdViajes(long l) {
//// =======
//		return listaViajes;
//	}


	@Override
	public Viajes findId(long l) {

		Connection con = null;
		PreparedStatement prep = null;
// >>>>>>> master

		try {
			String sql = "SELECT * FROM viajes WHERE id=?";

			con = Conexion.getConnection();
			prep = con.prepareStatement(sql);

			prep.setInt(1, (int) id);

			ResultSet rs = prep.executeQuery();

			Viajes viaje = new Viajes();

			if (rs.next()) {
				viaje.setViajes_ID(rs.getInt("viajes_ID"));
//				viaje.setChofer((Choferes) rs).getChofer("chofer");
//				viaje.setCamion((Camiones) rs).getCamion("camion"); //no se bien como es esto
				viaje.setConsumo_nafta(rs.getInt("consumo_nafta"));
				viaje.setOrigen(rs.getString("origen"));
				viaje.setDestino(rs.getString("destino"));
				viaje.setDistancia(rs.getDouble("distancia"));

				viaje.add(viaje);
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


}
