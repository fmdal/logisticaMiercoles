package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.dao.iCamionesDAO;
import negocio.dao.factory.CamionesFactory;
import negocio.dominio.Camiones;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/CamionesController")
public class CamionesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CamionesController() {
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

			iCamionesDAO<Camiones> camionesDAO = CamionesFactory.getImplementation("DB");

			if (request.getParameter("accion").equals("alta")) {
				Camiones camion = new Camiones();

				camion.setPatente(request.getParameter("patente"));
				camion.setContrasenia(request.getParameter("contrasenia"));
				camion.setTanque_nafta(Double.parseDouble(request.getParameter("telefono")));
				camion.setPeso_max(Double.parseDouble(request.getParameter("pesoMax")));
				camion.setLitrosxKm(Double.parseDouble(request.getParameter("listrosxKm")));

				camionesDAO.add(camion);

			} else if (request.getParameter("accion").equals("baja")) {

				camionesDAO.deleteById(request.getParameter("userID"));

			} else if (request.getParameter("accion").equals("modif")) {
				Camiones camion = new Camiones();

				camion.setPatente(request.getParameter("patente"));
				camion.setContrasenia(request.getParameter("contrasenia"));
				camion.setTanqueNafta(Double.parseDouble(request.getParameter("telefono")));
				camion.setPesoMax(Double.parseDouble(request.getParameter("pesoMax")));
				camion.setLitrosxKm(Double.parseDouble(request.getParameter("listrosxKm")));

				camionesDAO.save(camion);

			} else if (request.getParameter("accion").equals("busca")) {

				Camiones cli = (Camiones) camionDAO.findId(Long.parseLong(request.getParameter("userID")));

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
