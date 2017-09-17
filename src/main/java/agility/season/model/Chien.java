package agility.season.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Chien implements Serializable, Comparable<Chien> {
    private String nom;
    private Boolean large;
    private List<Resultat> resultats = new ArrayList<Resultat>();

    public Chien() {
    }

    public Chien(String nom, Boolean large) {
	super();
	this.nom = nom;
	this.large = large;
    }

    public Chien(String nom) {
	super();
	this.nom = nom;
	this.large = true;
    }

    @Override
    public String toString() {
	return nom;
    }

    @Override
    public int compareTo(Chien o) {
	return nom.compareTo(o.nom);
    }
}
