package daoo;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import metier.entities.Genre;
import metier.entities.Genre;
import util.JPAutil;

public class GenreDaoImpl implements IGenreDao {
// TP6_JEE à replacer par votre persistence unit, consultez votre
//fichier persistence.xml <persistence-unit name="TP6_JEE">
	private EntityManager entityManager = JPAutil.getEntityManager("TP6.Livre_JEE");

	public Genre save(Genre col) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(col);
		tx.commit();
		return col;
	}




	


	@Override
	public Genre getGenre(Long id) {
		return entityManager.find(Genre.class, id);

	}

	@Override
	public Genre updateGenre(Genre col) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(col);
		tx.commit();
		return col;
	}

	@Override
	public void deleteGenre(Long id) {
		Genre Genre = entityManager.find(Genre.class, id);

		 entityManager.getTransaction().begin();
		 entityManager.remove(Genre);
		 entityManager.getTransaction().commit();
		
		
	}

	@Override
	public List<Genre> getAllGenre() {
		List<Genre> col = entityManager.createQuery("select c from Genre c").getResultList();
		return col;
	}
}
