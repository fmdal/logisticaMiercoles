package controllers;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.dao.iCamionesDAO;
import negocio.dao.iChoferesDAO;
import negocio.dao.iViajesDAO;
import negocio.dao.factory.CamionesFactory;
import negocio.dao.factory.ChoferesFactory;
import negocio.dao.factory.ViajesFactory;
import negocio.dao.implementacion.ViajesImplementacion;
import negocio.dominio.Camiones;
import negocio.dominio.Choferes;
import negocio.dominio.Users;
import negocio.dominio.Viajes;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/ViajesController")
public class ViajesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Viajes viaje = new Viajes();
	private static 	List <Viajes> viajesList = new ArrayList<Viajes>();

	/**
	 * Default constructor.
	 */
	public ViajesController() {
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
		iViajesDAO<Viajes> viajesDAO = ViajesFactory.getImplementation("DB");

		viajesList = viajesDAO.getLista();
		
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

			iViajesDAO<Viajes> viajesDAO = ViajesFactory.getImplementation("DB");
			iChoferesDAO<Choferes> choferesDAO = ChoferesFactory.getImplementation("DB");
			iCamionesDAO<Camiones> camionesDAO = CamionesFactory.getImplementation("DB");

			if (request.getParameter("accion").equals("alta")) {

				Viajes viaje = viajesDAO.findId(Long.parseLong(request.getParameter("viajeID")));
				viaje.setCamion(
						camionesDAO.findId(viajesDAO.getCamionId(Integer.parseInt(request.getParameter("viajeID")))));

				ArrayList<Viajes> viajes = viajesDAO.getLista();

				for (Viajes viaj : viajes) {
					viaj.setCamion(camionesDAO.findId(viajesDAO.getCamionId(viaj.getViajes_ID())));

				}

				Viajes viaje = new Viajes();
				
				viaje.setViajes_ID(request.getParameter("viajes_ID"));
				viaje.setChofer(request.getParameter("viajes_ID"));
				viaje.setCamion(request.getParameter("camiones"));
				viaje.setConsumo_nafta(Float.parseFloat(request.getParameter("consumo_nafta")));
				viaje.setOrigen(request.getParameter("origen"));
				viaje.setDestino(request.getParameter("destino"));
				viaje.setDistancia(Double.parseDouble(request.getParameter("distancia")));
				

//				lista viajes?

				viajesDAO.add(viaje);

			} else if (request.getParameter("accion").equals("baja")) {

				viajesDAO.deleteById(request.getParameter("viajes_ID"));

			} else if (request.getParameter("accion").equals("modif")) {
				
				
			Viajes viajes = new Viajes();

			viaje.setViajes_ID(request.getParameter("viajes_ID"));
			viaje.setChofer(request.getParameter("viajes_ID"));
			viaje.setCamion(request.getParameter("camiones"));
			viaje.setConsumo_nafta(Float.parseFloat(request.getParameter("consumo_nafta")));
			viaje.setOrigen(request.getParameter("origen"));
			viaje.setDestino(request.getParameter("destino"));
			viaje.setDistancia(Double.parseDouble(request.getParameter("distancia")));

				viajesDAO.save(viajes);

			} else if (request.getParameter("accion").equals("busca")) {

				Viajes viaje = (Viajes) viajesDAO.findId(Integer.parseInt(request.getParameter("viajes_ID")));

			} else if (request.getParameter("accion").equals("login")) {

				Viajes viaje = (Viajes) viajesDAO.findId(Integer.parseInt(request.getParameter("viajes_ID")));

				if (request.getParameter("accion").equals("viajes_ID")) {
						
					viaje.setViajes_ID(Integer.parseInt(request.getParameter("viajes_ID")));
						
					// mostrar viaje (sacado del controller de user)

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

	public static Viajes getViaje() {
		return viaje;
	}

	public static void setViaje(Viajes viaje) {
		ViajesController.viaje = viaje;
	}

	public static List<Viajes> getViajesList() {
		return viajesList;
	}

	public static void setViajesList(List<Viajes> viajesList) {
		ViajesController.viajesList = viajesList;
	}

}