package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;

import daoo.GenreDaoImpl;
import daoo.IGenreDao;
import metier.entities.Genre;

@WebServlet(name = "genServ", urlPatterns = { "/Genres", "/saisieGenre", "/saveGenre", "/supprimergen",
		"/editergen", "/updategen" })
public class GenresServlet extends HttpServlet {
	IGenreDao type;

	@Override
	public void init() throws ServletException {
		type = new GenreDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println("PATH " + path);
		if (path.equals("/Genres")) {
			List<Genre> gen = type.getAllGenre();
			GenreModel model = new GenreModel();

			model.setGenres(gen);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Genres.jsp").forward(request, response);
			
		} else if (path.equals("/saisieGenre")) {
			System.out.println("*************************************************************************************************************");

			request.getRequestDispatcher("saisieGenre.jsp").forward(request, response);
			
		} else if (path.equals("/saveGenre") && request.getMethod().equals("POST")) {
			System.out.println("************eeee*************************************************************************************************");

			Date dategen = new Date();
			String nom = request.getParameter("nom");
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			try {
				dategen = simpleDateFormat.parse(request.getParameter("dategen"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			Genre gen = type.save(new Genre(nom, dategen));
			request.setAttribute("Genre", gen);
			response.sendRedirect("Genres");
			
			
		} else if (path.equals("/supprimergen")) {
			Long id = Long.parseLong(request.getParameter("id"));
			type.deleteGenre(id);
			response.sendRedirect("Genres");
			
			
		} else if (path.equals("/editergen")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Genre gen = type.getGenre(id); 
			request.setAttribute("Genre", gen);
			request.getRequestDispatcher("editerGenre.jsp").forward(request, response);
			
			
		} else if (path.equals("/updategen")) {
			Date dategen = new Date();
			Long id = Long.parseLong(request.getParameter("id"));
			String nomgen = request.getParameter("nomgen");
			Genre gen = new Genre();
			gen.setIdgenre(id);
			gen.setNomgenre(nomgen);
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			try {
				dategen = simpleDateFormat.parse(request.getParameter("dateSortie"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			gen.setDateSortie(dategen);
			type.updateGenre(gen);
			response.sendRedirect("Genres");
			
		} else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,

			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
