package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.dao.iChoferesDAO;
import negocio.dao.factory.ChoferesFactory;
import negocio.dominio.Choferes;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/ChoferesController")
public class ChoferesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ChoferesController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String destino;

		if (request.getParameter("accion") != null) {

			iChoferesDAO<Choferes> choferesDAO = ChoferesFactory.getImplementation("DB");

			if (request.getParameter("accion").equals("alta")) {
				Choferes chofer = new Choferes();

				chofer.setUserID(request.getParameter("userID"));
				chofer.setTelefono(Long.parseLong(request.getParameter("telefono")));
				chofer.setContrasenia(request.getParameter("contrasenia"));
				chofer.setNombre(request.getParameter("nombre"));
				chofer.setApellido(request.getParameter("apellido"));
//				chofer.setFechaNac(request.getParameter("fecha_nac"));
				chofer.setCategoria(request.getParameter("categoria"));

				choferesDAO.add(chofer);

			} else if (request.getParameter("accion").equals("baja")) {

				choferesDAO.deleteById(request.getParameter("userID"));

			} else if (request.getParameter("accion").equals("modif")) {
				Choferes chofer = new Choferes();

				chofer.setUserID(request.getParameter("userID"));
				chofer.setTelefono(Long.parseLong(request.getParameter("telefono")));
				chofer.setContrasenia(request.getParameter("contrasenia"));
				chofer.setNombre(request.getParameter("nombre"));
				chofer.setApellido(request.getParameter("apellido"));
//				chofer.setFechaNac(request.getParameter("fecha_nac"));
				chofer.setCategoria(request.getParameter("categoria"));

				choferesDAO.save(chofer);

			} else if (request.getParameter("accion").equals("busca")) {

				Choferes cli = (Choferes) choferesDAO.findId(Long.parseLong(request.getParameter("userID")));

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
