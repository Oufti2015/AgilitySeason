package agility.season.controllers;

import java.util.List;
import java.util.stream.Collectors;

import agility.season.AgilitySeason;
import agility.season.model.Activite;
import agility.season.model.Chien;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
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
	System.out.println("chiens " + chiens);
	System.out.println("agilityTableView " + agilityTableView);
	System.out.println("jumpingTableView " + jumpingTableView);
	agility = new ResultatsTableColumns(agilityTableView);
	jumping = new ResultatsTableColumns(jumpingTableView);

	chiens.getSelectionModel().select(0);

	System.out.println("selected " + chiens.getSelectionModel().getSelectedIndex());

    }

    public void setData(List<Chien> chiensData) {
	chiens.getItems().addAll(chiensData);
    }

    @FXML
    public void selectChien() {

	Chien chien = chiens.getSelectionModel().getSelectedItem();
	System.out.println("selected " + chien + " resultats " + chien.getResultats().size());

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

	System.out.println("agilityResultats " + agilityResultats.size());
	System.out.println("jumpingResultats " + jumpingResultats.size());

	agilityTableView.getItems().setAll(agilityResultats);
	jumpingTableView.getItems().setAll(jumpingResultats);

	int agilitySum = agilityResultats.stream().mapToInt(ResultatModel::getClassement).sum();
	int jumpingSum = jumpingResultats.stream().mapToInt(ResultatModel::getClassement).sum();
	agilityTotal.setText("" + agilitySum);
	jumpingTotal.setText("" + jumpingSum);

	total.setText("" + (agilitySum + jumpingSum));
    }
}
