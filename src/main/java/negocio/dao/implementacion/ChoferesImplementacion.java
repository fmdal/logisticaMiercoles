package negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import core.Conexion;
import negocio.dao.iDAO;
import negocio.dominio.Choferes;

public class ChoferesImplementacion implements iDAO<Choferes> {

	@Override
	public boolean add(Choferes elemento) {

		String sql = "INSERT INTO choferes(userID, nombre, apellido, contrasenia, fecha_nac, telefono, categoria, listaCamiones) VALUES (?,?,?,?,?,?,?,?)";

		try {
			Connection con = Conexion.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, elemento.getUser_ID());
			ps.setString(4, elemento.getContrasenia());
			ps.setString(2, elemento.getNombre());
			ps.setString(3, elemento.getApellido());
//			ps.setDate(5, elemento.getFechaNac());
			ps.setString(6, elemento.getTelefono());
			ps.setString(7, elemento.getCategoria());
//			ps.setString(8, elemento.getListaCamiones());
			
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
	public ArrayList<Choferes> getLista() {

		ArrayList<Choferes> chofer = new ArrayList<>();

		Connection con = null;
		PreparedStatement prep = null;

		try {
			con = Conexion.getConnection();
			prep = con.prepareStatement("SELECT * FROM choferes");

			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				Choferes chofer1 = new Choferes();
				
				chofer1.setUser_ID(rs.getInt("user_ID"));
				chofer1.setContrasenia(rs.getString("contrasenia"));
				chofer1.setNombre(rs.getString("nombre"));
				chofer1.setApellido(rs.getString("apellido"));
//				chofer.setFecha_nac(rs.getDate("fecha_nac"));
				chofer1.setTelefono(rs.getString("telefono"));
				chofer1.setCategoria(rs.getString("categoria"));
//				chofer.setLista_camiones(rs.getLong("lista_camiones")); aca deberia ir con array

//				Choferes.add(chofer); no se que pasa con el objeto
			}
			prep.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return chofer;
	}

	@Override
	public Choferes findId(long l) {

		Connection con = null;
		PreparedStatement prep = null;

		try {
			String sql = "SELECT * FROM choferes WHERE userID=?";

			con = Conexion.getConnection();
			prep = con.prepareStatement(sql);

			int id = 0; //inicialice aca
			prep.setInt(1, (int) id);

			ResultSet rs = prep.executeQuery();

			Choferes chofer = new Choferes();

			if (rs.next()) {
				chofer.setUser_ID(rs.getInt("userID"));
				chofer.setNombre(rs.getString("nombre"));
				chofer.setApellido(rs.getString("apellido"));
				chofer.setContrasenia(rs.getString("contrasenia"));
//				chofer.setFechaNac(rs.getString("contrasenia"));
				chofer.setTelefono(rs.getString("telefono"));
				chofer.setCategoria(rs.getString("categoria"));
//				chofer.setListaCamiones(rs.getLong("listaCamiones"));
		}
			return chofer;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteById(long l) {

		String sql = "UPDATE choferes SET activo=0 WHERE userID=?";
	
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
	public boolean save(Choferes elemento) {
		// TODO Auto-generated method stub
		return false;
	}
}
