package negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.Conexion;
import negocio.dao.iDAO;
import negocio.dominio.Camiones;
import negocio.dominio.Users;

public class CamionesImplementacion implements iDAO<Camiones> {

	@Override
	public boolean add(Camiones elemento) {

		String sql = "INSERT INTO camiones(patente, marca, modelo, tanqueNafta, pesoMax, litrosxKm) VALUES (?,?,?,?,?,?)";

		try {
			Connection con = Conexion.getConnection(); // resolver conexion

			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt (1, elemento.getCamion_ID());
			ps.setString(2, elemento.getPatente());
			ps.setString(3, elemento.getMarca());
			ps.setString(4, elemento.getModelo());
			ps.setInt(5, elemento.getTanque_nafta());
			ps.setInt(6, elemento.getPeso_max());
			ps.setDouble(7, elemento.getLitrosxkm());
//			ps.setDisponible(8, elemento.isDisponible());  //no se que paso aca, no me toma el boolean

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
	public ArrayList<Users> getLista() {

		ArrayList<Camiones> camiones = new ArrayList<>();

		Connection con = null;
		PreparedStatement prep = null;

		try {
			con = Conexion.getConnection();
			prep = con.prepareStatement("SELECT * FROM camiones");

			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				Camiones camion = new Camiones();
				
				int camion_ID;
				String patente;
				String marca;
				String modelo;
				int tanque_nafta;
				int peso_max;
				double litrosxkm;
				boolean disponible;  //no se si va esto aca
				
				camion.setCamionID(rs.getInt(camion_ID));
				camion.setPatente(rs.getString("patente"));
				camion.setMarca(rs.getString("marca"));
				camion.setModelo(rs.getString("modelo"));
				camion.setTanqueNafta(rs.getdouble(tanque_nafta));
				camion.setPesoMax(rs.getDouble(peso_max));
				camion.setListrosxKm(rs.getDouble(litrosxkm));
				camion.isDisponible(rs.getDisponible(disponible));
				camiones.add(camion);
			}
			prep.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return camiones;
	}

	@Override
	public Camion findId(long l) {

		Connection con = null;
		PreparedStatement prep = null;

		try {
			String sql = "SELECT * FROM camiones WHERE patente=?";

			con = Conexion.getConnection();
			prep = con.prepareStatement(sql);

			prep.setInt(1, (int) id);

			ResultSet rs = prep.executeQuery();

			Camiones camion = new Camiones();

			if (rs.next()) {
				
				int camion_ID;
				String patente;
				String marca;
				String modelo;
				int tanque_nafta;
				int peso_max;
				double litrosxkm;
				boolean disponible;
				
				
				camion.setCamionID(rs.getInt(camion_ID));
				camion.setPatente(rs.getString("patente"));
				camion.setMarca(rs.getString("marca"));
				camion.setModelo(rs.getString("modelo"));
				camion.setTanqueNafta(rs.getdouble(tanque_nafta));
				camion.setPesoMax(rs.getDouble(peso_max));
				camion.setListrosxKm(rs.getDouble(litrosxkm));
				camion.isDisponible(rs.getDisponible(disponible));
				camiones.add(camion);

			}
			return camion;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteById(long l) {

		String sql = "UPDATE camiones SET activo=0 WHERE patente=?";

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
