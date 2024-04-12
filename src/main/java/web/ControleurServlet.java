package web;

import java.io.IOException;


import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import daoo.GenreDaoImpl;
import daoo.IGenreDao;
import daoo.ILivreDao;
import daoo.LivreDaoImpl;
import metier.entities.Genre;
import metier.entities.Livre;
import daoo.IGenreDao;

@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
ILivreDao metier;
IGenreDao metierCol ; 
@Override
public void init() throws ServletException {
	System.out.println("*************************************************************************************************************");

metier = new LivreDaoImpl();
metierCol = new GenreDaoImpl() ; 

}
@Override
protected void doGet(HttpServletRequest request,
		 HttpServletResponse response)
		 throws ServletException, IOException {  
		String path=request.getServletPath();
		 if (metier == null) {
		        // Initialize metier if it's null
		        metier = new LivreDaoImpl();
		    }

		if (path.equals("/index.do"))
		{

		request.getRequestDispatcher("Livre.jsp").forward(request,response);
		}
		else if (path.equals("/chercher.do"))
		{
			String motCle=request.getParameter("motCle");
			LivreModele model= new LivreModele();
			model.setMotCle(motCle);
			List<Livre> prods = metier.livresParMC(motCle);
			model.setLivre(prods);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Livre.jsp").forward(request,response);
		}
		else if (path.equals("/create.do") )
		{
			System.out.println("*************************************************************************************************************");

			List<Genre> col = metierCol.getAllGenre();
			System.out.println(col);
			GenreModel model= new GenreModel();
			model.setGenres(col);
			request.setAttribute("colModel", model);
			request.getRequestDispatcher("saisieLivre.jsp").forward(request,response);		}
	
		
		
		
		
		
		else if (path.equals("/save.do") &&
		request.getMethod().equals("POST"))
		{
			
			String titre = request.getParameter("titreLivre");
            String auteur = request.getParameter("auteur");
           double prix = Double.parseDouble(request.getParameter("prix"));
            
            int nbpages = Integer.parseInt(request.getParameter("nbpages"));
    		Long idgenre=Long.parseLong(request.getParameter("genre"));

    		Genre col = metierCol.getGenre(idgenre);

            Livre l = metier.save(new Livre(titre, auteur, prix,  nbpages,col));
		request.setAttribute("Livre", l);
		request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		
		
		else if (path.equals("/supprimer.do"))
		{
		 Long id= Long.parseLong(request.getParameter("id"));
		 metier.deleteLivre(id);
		 response.sendRedirect("chercher.do?motCle=");
		}
		else if (path.equals("/editer.do") )
		{
			Long id= Long.parseLong(request.getParameter("id"));
		 Livre p = metier.getLivre(id);
		 request.setAttribute("Livre", p);
		 
		 List<Genre> col = metierCol.getAllGenre();
		 GenreModel model= new GenreModel();
		 model.setGenres(col);
		 request.setAttribute("colModel", model);
		request.getRequestDispatcher("editerLivre.jsp").forward(request,response);		}
		else if (path.equals("/update.do") )
		{
			  Long id = Long.parseLong(request.getParameter("id"));
              String titreLivre = request.getParameter("titreLivre");
              String auteur = request.getParameter("auteur");
              double prix = Double.parseDouble(request.getParameter("prix"));
              int nbpages = Integer.parseInt(request.getParameter("nbpages"));
      		Long idgenre=Long.parseLong(request.getParameter("genre"));

		Livre l = new Livre();
		l.setIdLivre(id);
        l.setTitreLivre(titreLivre);
        l.setAuteur(auteur);
        l.setPrix(prix);
        l.setNbpages(nbpages);
        metier.updateLivre(l);
		
		
		
		Genre gen = metierCol.getGenre(idgenre);
		l.setGenre(gen);
		metier.updateLivre(l);
		response.sendRedirect("chercher.do?motCle=");

		}
		else
		{
			response.sendError(Response.SC_NOT_FOUND);		
		}	
		}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}