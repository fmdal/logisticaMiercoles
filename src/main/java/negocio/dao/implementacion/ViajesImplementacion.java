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
		@Override
		@Override
		public boolean add(Viajes elemento) {

			String sql = "INSERT INTO viajes(viajesID, chofer, camion, consumoNafta, trayecto) VALUES (?,?,?,?,?)";

			try {
				Connection con = Conexion.getConnection();

				PreparedStatement ps = con.prepareStatement(sql);

				ps.setString(1, elemento.getViajesID());
				ps.setString(2, elemento.getChofer());
				ps.setString(3, elemento.getCamion());
				ps.setString(4, elemento.getConsumoNafta());
				ps.setString(5, elemento.getTrayectos());
				
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

			ArrayList<Viajes> listaViajes = new ArrayList<>();

			Connection con = null;
			PreparedStatement prep = null;

			try {
				con = Conexion.getConnection();
				prep = con.prepareStatement("SELECT * FROM listaViajes");

				ResultSet rs = prep.executeQuery();

				while (rs.next()) {

					Viajes viaje = new Viajes();

					viaje.setViajesID(rs.getint("viajesID"));
					viaje.setChofer((Choferes) rs).getChofer("chofer");
					viaje.setCamion(rs.getString("camion"));
					viaje.setConsumoNafta(rs.getDate("consumoNafta"));
					viaje.setTrayectos(rs.getLong("trayectos"));
					listaViajes.add(viaje);
				}
				prep.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaViajes;
		}

		@Override
		@Override
		@Override
		@Override
		@Override
		@Override
		@Override
		public Viajes findId(long l) {

			Connection con = null;
			PreparedStatement prep = null;

			try {
				String sql = "SELECT * FROM viajes WHERE id=?";

				con = Conexion.getConnection();
				prep = con.prepareStatement(sql);

				prep.setInt(1, (int) id);

				ResultSet rs = prep.executeQuery();

				Viajes viaje = new Viajes();

				if (rs.next()) {
					viaje.setViajesID(rs.getInt("viajesID"));
					viaje.setChofer(((Viajes) rs).getChofer());
					viaje.setCamion(((Viajes) rs).getCamion());
					viaje.setConsumoNafta(rs.getFloat("consumoNafta"));
					viaje.setTrayectos(((Viajes) rs).getTrayectos());
					viaje.add(viaje);

				}
				return viaje;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		@Override
		@Override
		@Override
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
