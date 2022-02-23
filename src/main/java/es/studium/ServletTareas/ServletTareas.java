package es.studium.ServletTareas;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletTareas
 */
@WebServlet("/ServletTareas")
public class ServletTareas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTareas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Indicamos idioma
		request.setCharacterEncoding("UTF-8"); 
		// Recupera la sesión actual o crea una nueva si no existe 
		HttpSession session = request.getSession(true); 
		// Recupera la lista de la sesión actual 
		@SuppressWarnings("unchecked") 
		ArrayList<String> lista = (ArrayList<String>) session.getAttribute("lista"); 


		//Optenemos los parametros
		String tarea=request.getParameter("tarea");
		//Optenemos la fecha y la formateamos
		Date fecha=new java.util.Date();
		String fechaFormateada = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(fecha);
		//Preparamos lo que queremos guardar
		String enviar=null;
		if (tarea!=null) {
		enviar=tarea+" "+fechaFormateada;
		}
		//Comprobamos si la lista esta vacia
		if(lista==null) {
			// El carrito está vacío 
			lista = new ArrayList<>();
			if (enviar!=null) {
			lista.add(enviar); 
			}
			// Enlazar el carrito con la sesión 
			session.setAttribute("lista", lista); 
		}else {
			if (enviar!=null) {
			lista.add(enviar); 
			}
			// Enlazar el carrito con la sesión 
			session.setAttribute("lista", lista); 
		}
		//request.setAttribute("respuesta", lista);
		// Redirigimos a index.jsp
		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/index.jsp");
		//Enviamos el request y response
		requestDispatcher.forward(request, response); 
	}

}
