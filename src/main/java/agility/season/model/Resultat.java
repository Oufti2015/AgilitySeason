package agility.season.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Resultat implements Comparable<Resultat>, Serializable {
    private Activite activite;
    private LocalDate date;
    private String concours;
    private String points;
    private Integer classement;
    private Boolean dk;

    public Resultat(Activite activite) {
	super();
	this.activite = activite;
	this.date = LocalDate.now();
	this.concours = "-------";
	this.dk = false;
	this.points = "---";
	this.classement = 200;
    }

    public Resultat(Activite activite, LocalDate date, String concours, Boolean dk) {
	super();
	this.activite = activite;
	this.date = date;
	this.concours = concours.toUpperCase();
	this.dk = dk;
	this.classement = 200;
    }

    public Resultat(Activite activite, LocalDate date, String concours, String points, Integer classement) {
	super();
	this.activite = activite;
	this.date = date;
	this.concours = concours.toUpperCase();
	this.points = points;
	this.classement = classement;
	this.dk = false;
    }

    @Override
    public int compareTo(Resultat o) {
	int result = 0;
	result = classement.compareTo(o.classement);
	if (result == 0 && date != null) {
	    result = date.compareTo(o.date);
	}
	return result;
    }

    @Override
    public String toString() {
	return String.format("%-15s : %10s %20s %6s %6d", activite, date, concours, dk ? "DK" : points, classement);
    }
}
