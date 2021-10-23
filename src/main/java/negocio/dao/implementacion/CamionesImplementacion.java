package negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import core.Conexion;
import negocio.dao.iDAO;
import negocio.dominio.Camiones;
import negocio.dominio.Users;

public class CamionesImplementacion implements iDAO<Camiones> {

	@Override
	public boolean add(Camiones elemento) {

		String sql = "INSERT INTO camiones(patente, marca, modelo, tanqueNafta, pesoMax, litrosxKm) VALUES (?,?,?,?,?,?)";

		try {
			Connection con = Conexion.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, elemento.getPatente());
			ps.setString(2, elemento.getMarca());
			ps.setString(3, elemento.getModelo());
			ps.setDouble(4, elemento.getTanqueNafta());
			ps.setDouble(5, elemento.getPesoMax());
			ps.setDouble(6, elemento.getLitrosxKm());

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

				camion.setPatente(rs.getString("patente"));
				camion.setMarca(rs.getString("marca"));
				camion.setModelo(rs.getString("modelo"));
				camion.setTanqueNafta(rs.getdouble("tanqueNafta"));
				camion.setPesoMax(rs.getDouble("pesoMax"));
				camion.setListrosxKm(rs.getDouble("litrosxKm"));
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
				camion.setUserID(rs.getString("patente"));
				camion.setNombre(rs.getString("marca"));
				camion.setApellido(rs.getString("modelo"));
				camion.setContrasenia(rs.getdouble("tanqueNafta"));
				camion.setFechaNac(rs.getDouble("pesoMax"));
				camion.setTelefono(rs.getDouble("litrosxKm"));

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
