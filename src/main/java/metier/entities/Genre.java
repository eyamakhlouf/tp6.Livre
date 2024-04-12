package metier.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Genre implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idgenre;
	private String nomgenre;

	@Temporal(TemporalType.DATE)
	private Date dateSortie;

	@OneToMany(mappedBy = "genre")

	private List<Livre> livres;
	
	
	
	

	public Genre() {
	}

	public Genre(String nomgenre, Date dateSortie) {
		super();
		this.nomgenre = nomgenre;
		this.dateSortie = dateSortie;
	}

	public Long getIdgenre() {
		return idgenre;
	}

	public void setIdgenre(Long idgenre) {
		this.idgenre = idgenre;
	}

	public String getNomgenre() {
		return nomgenre;
	}

	public void setNomgenre(String nomgenre) {
		this.nomgenre = nomgenre;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

}