package agility.season.controllers;

import java.time.LocalDate;

import agility.season.model.Resultat;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ResultatModel {
    private IntegerProperty id;
    final private ObjectProperty<LocalDate> date;
    final private StringProperty concours;
    final private StringProperty points;
    final private IntegerProperty classement;

    public ResultatModel(Resultat resultat) {
	id = new SimpleIntegerProperty(1);
	date = new SimpleObjectProperty<LocalDate>(resultat.getDate());
	concours = new SimpleStringProperty(resultat.getConcours());
	points = new SimpleStringProperty(resultat.getDk() ? "DK" : resultat.getPoints());
	classement = new SimpleIntegerProperty(resultat.getClassement());
    }

    public void id(Integer i) {
	id = new SimpleIntegerProperty(i);
    }

    public IntegerProperty id() {
	return id;
    }

    public ObjectProperty<LocalDate> date() {
	return date;
    }

    public StringProperty concours() {
	return concours;
    }

    public StringProperty points() {
	return points;
    }

    public IntegerProperty classement() {
	return classement;
    }

    public Integer getId() {
	return id.get();
    }

    public LocalDate getDate() {
	return date.get();
    }

    public String getConcours() {
	return concours.get();
    }

    public String getPoints() {
	return points.get();
    }

    public Integer getClassement() {
	return classement.get();
    }

}
