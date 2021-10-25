package negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import core.Conexion;
import negocio.dao.iDAO;
import negocio.dominio.Users;

public class UsersImplementacion implements iDAO<Users> {

	
	@Override
	public boolean add(Users elemento) {

		String sql = "INSERT INTO users(userID, nombre, apellido, contrasenia, fecha_nac, telefono) VALUES (?,?,?,?,?,?)";

		try {
			Connection con = Conexion.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			
			ps.setInt(1, elemento.getUser_ID());
			ps.setString(4, elemento.getContrasenia());
			ps.setString(2, elemento.getNombre());
			ps.setString(3, elemento.getApellido());
//			ps.setDate(5, elemento.getFechaNac());
			ps.setString(6, elemento.getTelefono());

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
	public ArrayList<Users> getLista() {

		ArrayList<Users> usuarios = new ArrayList<>();

		Connection con = null;
		PreparedStatement prep = null;

		try {
			con = Conexion.getConnection();
			prep = con.prepareStatement("SELECT * FROM users");

			ResultSet rs = prep.executeQuery();

			while (rs.next()) {

				Users usuario = new Users();

				usuario.setUser_ID(rs.getInt("user_ID"));
				usuario.setContrasenia(rs.getString("contrasenia"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
//				usuario.setFecha_nac(rs.getDate("fecha_nac"));
				usuario.setTelefono(rs.getString("telefono"));

				usuarios.add(usuario);
			}
			prep.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	@Override
	public Users findId(long l) {

		Connection con = null;
		PreparedStatement prep = null;

		try {
			String sql = "SELECT * FROM users WHERE id=?";

			con = Conexion.getConnection();
			prep = con.prepareStatement(sql);

			prep.setInt(1, (int) id);

			ResultSet rs = prep.executeQuery();

			Users usuario = new Users();

			if (rs.next()) {
				
				
				usuario.setUser_ID(rs.getInt("user_ID"));
				usuario.setContrasenia(rs.getString("contrasenia"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
//				usuario.setFecha_nac(rs.getDate("fecha_nac"));
				usuario.setTelefono(rs.getString("telefono"));


			}
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteById(long l) {

		String sql = "UPDATE users SET activo=0 WHERE userID=?";

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
	public boolean save(Users elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
