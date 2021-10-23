package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import negocio.dao.iDAO;
import negocio.dao.factory.UsersFactory;
import negocio.dominio.Users;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/UsersController")
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public UsersController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String destino;

		if (request.getParameter("accion") != null) {

			iDAO<Users> usersDAO = UsersFactory.getImplementation("DB");

			if (request.getParameter("accion").equals("alta")) {
				Users user = new Users();

				user.setUserID(request.getParameter("userID"));
				user.setTelefono(Long.parseLong(request.getParameter("telefono")));
				user.setContrasenia(request.getParameter("contrasenia"));
				user.setNombre(request.getParameter("nombre"));
				user.setApellido(request.getParameter("apellido"));
				user.setFechaNac(request.getParameter("fecha_nac"));
//				user.setTelefono(Long.parseLong(request.getParameter("listaViajes")));

				usersDAO.add(user);

			} else if (request.getParameter("accion").equals("baja")) {

				usersDAO.deleteById(request.getParameter("userID"));

			} else if (request.getParameter("accion").equals("modif")) {
				Users user = new Users();

				user.setUserID(request.getParameter("userID"));
				user.setTelefono(Long.parseLong(request.getParameter("telefono")));
				user.setContrasenia(request.getParameter("contrasenia"));
				user.setNombre(request.getParameter("nombre"));
				user.setApellido(request.getParameter("apellido"));
				user.setFechaNac(request.getParameter("fecha_nac"));
//				user.setTelefono(Long.parseLong(request.getParameter("listaViajes")));

				usersDAO.save(user);

			} else if (request.getParameter("accion").equals("busca")) {

				Users usr = (Users) usersDAO.findId(Long.parseLong(request.getParameter("userID")));

			} else if (request.getParameter("accion").equals("login")) {

				Users usr = (Users) usersDAO.findId(Long.parseLong(request.getParameter("userID")));

				if (usr.getContrasenia() != null && usr.getContrasenia().equals(request.getParameter("contrasenia"))) {

					Cookie cookieUs = new Cookie("userID", URLEncoder.encode(request.getParameter("userID"), "UTF-8"));
					Cookie cookieClave = new Cookie("contrasenia",
							URLEncoder.encode(request.getParameter("contrasenia"), "UTF-8"));
					cookieUs.setMaxAge(365 * 24 * 60 * 60);
					cookieClave.setMaxAge(365 * 24 * 60 * 60);
					response.addCookie(cookieUs);
					response.addCookie(cookieClave);

					HttpSession misession = request.getSession(true);
					misession.setAttribute("userID", request.getParameter("userID"));

					destino = "perfilAdmin.jsp";

				}

			} else {
				request.getSession().setAttribute("Error", "Tipo de accion incorrecta");
				destino = "error.jsp";
			}

		} else {
			request.getSession().setAttribute("Error", "Se requiere que haya una accion");
			destino = "error.jsp";
		}

		request.getRequestDispatcher(destino).forward(request, response);
	}

}
