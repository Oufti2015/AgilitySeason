package agility.season.controllers;

import java.time.LocalDate;

import agility.season.controllers.util.LocalDateStringConverter;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;

public class ResultatsTableColumns {
    private TableColumn<ResultatModel, String> idColumn;
    private TableColumn<ResultatModel, LocalDate> dateColumn;
    private TableColumn<ResultatModel, String> concoursColumn;
    private TableColumn<ResultatModel, String> pointsColumn;
    private TableColumn<ResultatModel, Integer> classementColumn;

    public ResultatsTableColumns(TableView<ResultatModel> table) {
	idColumn = new TableColumn<>("Id");
	idColumn.setCellValueFactory(new PropertyValueFactory<ResultatModel, String>("id"));
	columnSize(idColumn, 30);
	table.getColumns().add(idColumn);

	dateColumn = new TableColumn<>("Date");
	dateColumn.setCellValueFactory(new PropertyValueFactory<ResultatModel, LocalDate>("date"));
	table.getColumns().add(dateColumn);
	columnSize(dateColumn, 100);
	formatLocalDateColumn(dateColumn);

	concoursColumn = new TableColumn<>("Concours");
	concoursColumn.setCellValueFactory(new PropertyValueFactory<ResultatModel, String>("concours"));
	columnSize(concoursColumn, 200);
	table.getColumns().add(concoursColumn);

	pointsColumn = new TableColumn<>("R�sultat");
	pointsColumn.setCellValueFactory(new PropertyValueFactory<ResultatModel, String>("points"));
	columnSize(pointsColumn, 60);
	table.getColumns().add(pointsColumn);
	pointsColumn.getStyleClass().add("right-align");

	classementColumn = new TableColumn<>("Classement");
	classementColumn.setCellValueFactory(new PropertyValueFactory<ResultatModel, Integer>("classement"));
	columnSize(classementColumn, 60);
	table.getColumns().add(classementColumn);
	classementColumn.getStyleClass().add("right-align");

	classementColumn.setCellFactory(column -> {
	    return new TableCell<ResultatModel, Integer>() {
		@Override
		protected void updateItem(Integer item, boolean empty) {
		    super.updateItem(item, empty);

		    setText(empty ? "" : getItem().toString());
		    setGraphic(null);

		    TableRow<ResultatModel> currentRow = getTableRow();

		    ResultatModel resultat = currentRow.getItem();
		    currentRow.getStyleClass().clear();
		    if (!isEmpty() && resultat != null) {
			if ("DK".equals(resultat.getPoints())) {
			    currentRow.getStyleClass().add("dk");
			} else if ("0".equals(resultat.getPoints())) {
			    currentRow.getStyleClass().add("sansfaute");
			} else if ("---".equals(resultat.getPoints())) {
			    currentRow.getStyleClass().add("noexists");
			} else {
			    currentRow.getStyleClass().add("ok");
			}
		    } else {
			currentRow.getStyleClass().add("ok");
		    }
		}
	    };
	});
    }

    private void columnSize(TableColumn<ResultatModel, ?> column, int i) {
	column.setMinWidth(i);
	column.setMaxWidth(i);
    }

    private static Callback<TableColumn<ResultatModel, LocalDate>, TableCell<ResultatModel, LocalDate>> forTableColumLocalDate = TextFieldTableCell
	    .<ResultatModel, LocalDate> forTableColumn(new LocalDateStringConverter());

    private void formatLocalDateColumn(TableColumn<ResultatModel, LocalDate> column) {
	column.setCellFactory(forTableColumLocalDate);
	// column.setStyle("-fx-alignment: CENTER-RIGHT;");
    }
}
