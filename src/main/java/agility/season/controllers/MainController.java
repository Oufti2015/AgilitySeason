package agility.season.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import agility.season.AgilitySeason;
import agility.season.model.Activite;
import agility.season.model.Chien;
import agility.season.model.Resultat;
import agility.season.utils.NewResultatChange;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lombok.Setter;

public class MainController {
    @Setter
    private AgilitySeason owner;
    @FXML
    private ComboBox<Chien> chiens;
    @FXML
    private TableView<ResultatModel> agilityTableView;
    @FXML
    private TableView<ResultatModel> jumpingTableView;
    @FXML
    Label agilityTotal;
    @FXML
    Label jumpingTotal;
    @FXML
    Label total;
    @FXML
    private ComboBox<Activite> activiteAdd;
    @FXML
    private DatePicker dateAdd;
    @FXML
    private TextField concoursAdd;
    @FXML
    private TextField pointsAdd;
    @FXML
    private TextField classementAdd;
    @FXML
    private RadioButton dkAdd;
    @FXML
    private Button addButton;
    @FXML
    private TextField newDog;
    @FXML
    private Button newDogButton;

    private ResultatsTableColumns agility;
    private ResultatsTableColumns jumping;

    public MainController() {
	super();
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
	// System.out.println("chiens " + chiens);
	// System.out.println("agilityTableView " + agilityTableView);
	// System.out.println("jumpingTableView " + jumpingTableView);
	agility = new ResultatsTableColumns(agilityTableView);
	jumping = new ResultatsTableColumns(jumpingTableView);

	activiteAdd.getItems().addAll(Activite.values());

	// agilityTotal.getStyleClass().clear();
	agilityTotal.getStyleClass().add("points");
	jumpingTotal.getStyleClass().add("points");
	total.getStyleClass().add("points");

	disableForm();
    }

    private void disableForm() {
	activiteAdd.setDisable(true);
	dateAdd.setDisable(true);
	concoursAdd.setDisable(true);
	pointsAdd.setDisable(true);
	classementAdd.setDisable(true);
	dkAdd.setDisable(true);
	addButton.setDisable(true);
    }

    private void enableForm() {
	activiteAdd.setDisable(false);
	dateAdd.setDisable(false);
	concoursAdd.setDisable(false);
	pointsAdd.setDisable(false);
	classementAdd.setDisable(false);
	dkAdd.setDisable(false);
	addButton.setDisable(false);
    }

    public void setData(List<Chien> chiensData) {
	chiens.getItems().addAll(chiensData);
	chiens.getSelectionModel().select(0);
	selectChien();
    }

    @FXML
    public void selectChien() {
	enableForm();

	Chien chien = chiens.getSelectionModel().getSelectedItem();
	System.out.println("selected " + chien + " resultats " + chien.getResultats().size());

	// completeResultats(chien, Activite.AGILITY);
	// completeResultats(chien, Activite.JUMPING);

	List<ResultatModel> agilityResultats = chien.getResultats()
		.stream()
		.filter(r -> Activite.AGILITY.equals(r.getActivite()))
		.sorted()
		.limit(15)
		.map(r -> new ResultatModel(r))
		.collect(Collectors.toList());
	List<ResultatModel> jumpingResultats = chien.getResultats()
		.stream()
		.filter(r -> Activite.JUMPING.equals(r.getActivite()))
		.sorted()
		.limit(15)
		.map(r -> new ResultatModel(r))
		.collect(Collectors.toList());

	int i = 1;
	for (ResultatModel res : agilityResultats) {
	    res.id(i++);
	}
	i = 1;
	for (ResultatModel res : jumpingResultats) {
	    res.id(i++);
	}
	System.out.println("agilityResultats " + agilityResultats.size());
	System.out.println("jumpingResultats " + jumpingResultats.size());

	agilityTableView.getItems().setAll(agilityResultats);
	jumpingTableView.getItems().setAll(jumpingResultats);

	int agilitySum = calculateTotal(agilityResultats);
	int jumpingSum = calculateTotal(jumpingResultats);

	agilityTotal.setText("" + agilitySum);
	jumpingTotal.setText("" + jumpingSum);

	total.setText("" + (agilitySum + jumpingSum));
    }

    private int calculateTotal(List<ResultatModel> resultats) {
	int result = resultats.stream().mapToInt(ResultatModel::getClassement).sum();
	int count = resultats.size();
	return result + ((15 - count) * 200);
    }

    @FXML
    public void selectDKAdd() {
	if (dkAdd.isSelected()) {
	    pointsAdd.setText("");
	    pointsAdd.setDisable(true);
	    classementAdd.setText("200");
	    classementAdd.setDisable(true);
	} else {
	    pointsAdd.setDisable(false);
	    classementAdd.setText("");
	    classementAdd.setDisable(false);
	}
    }

    @FXML
    public void addResultat() {
	Activite activite = activiteAdd.getValue();
	LocalDate date = dateAdd.getValue();
	String concours = concoursAdd.getText();
	String points = pointsAdd.getText();
	String classement = classementAdd.getText();
	Boolean dk = dkAdd.isSelected();

	Chien chien = chiens.getSelectionModel().getSelectedItem();

	try {
	    if (chien == null) {
		new Alert(AlertType.ERROR, "Il faut choisir un chien...", ButtonType.OK).showAndWait();
	    } else if (activite == null || date == null || concours.isEmpty()
		    || (!dk && (points.isEmpty() || classement.isEmpty()))) {
		new Alert(AlertType.ERROR, "Il faut remplir tout les champs...", ButtonType.OK).showAndWait();
	    } else {
		if (dk) {
		    chien.getResultats().add(new Resultat(activite, date, concours, dk));
		} else {
		    chien.getResultats()
			    .add(new Resultat(activite, date, concours, points, Integer.parseInt(classement)));
		}
		AgilitySeason.eventBus.post(new NewResultatChange());
		selectChien();
	    }
	} catch (NumberFormatException nfe) {
	    new Alert(AlertType.ERROR, "Le classement doit être numérique...", ButtonType.OK).showAndWait();
	}
    }

    @FXML
    public void newDog() {
	String nomDuChien = newDog.getText();
	if (!nomDuChien.isEmpty()) {
	    final Alert alert = new Alert(AlertType.CONFIRMATION, "Voulez-vous creer " + nomDuChien + " ?",
		    ButtonType.YES, ButtonType.NO);
	    alert.showAndWait();
	    if (alert.getResult().equals(ButtonType.YES)) {
		Chien chien = new Chien(nomDuChien);
		owner.addChien(chien);
		chiens.getItems().add(chien);
		newDog.setText("");
	    }
	}
    }
}
