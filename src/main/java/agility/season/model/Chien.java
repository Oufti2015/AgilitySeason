package agility.season.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Chien {
    private String nom;
    private List<Resultat> resultats = new ArrayList<Resultat>();

    public Chien() {
    }

    public Chien(String nom) {
	super();
	this.nom = nom;
    }

    @Override
    public String toString() {
	return nom;
    }
}
