package metier.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "LIVRES")
public class Livre implements Serializable{
@Id
@Column (name="ID_LIVRE")
@GeneratedValue (strategy=GenerationType.IDENTITY)
private Long idLivre;

@Column (name="TITRE_LIVRE")
private String titreLivre;
private String auteur;
private double prix;
private int nbpages;

private Genre genre ;


public Livre() {
super();
}


public Livre(String titreLivre, String auteur, double prix, int nbpages , Genre gen) {
	
	this.titreLivre = titreLivre;
	this.auteur = auteur;
	this.prix = prix;
	this.nbpages = nbpages;
	this.setGenre(gen);
}


public double getPrix() {
return prix;
}
public void setPrix(double prix) {
this.prix = prix;
}
public Long getIdLivre() {
	return idLivre;
}
public void setIdLivre(Long idLivre) {
	this.idLivre = idLivre;
}
public String getTitreLivre() {
	return titreLivre;
}
public void setTitreLivre(String titreLivre) {
	this.titreLivre = titreLivre;
}
public String getAuteur() {
	return auteur;
}
public void setAuteur(String auteur) {
	this.auteur = auteur;
}

public int getNbpages() {
	return nbpages;
}
public void setNbpages(int nbpages) {
	this.nbpages = nbpages;
}


public Genre getGenre() {
	return genre;
}


public void setGenre(Genre genre) {
	this.genre = genre;
}}