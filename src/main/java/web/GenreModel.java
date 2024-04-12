package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Genre;


public class GenreModel {

     List<Genre> genres  = new ArrayList<>(); 
    public List<Genre> getGenres() {
        return this.genres ;
    }

        
    public void setGenres(List<Genre> Genre) { 
        this.genres  = Genre;
    }


	public GenreModel() {
		super();
	}






}
