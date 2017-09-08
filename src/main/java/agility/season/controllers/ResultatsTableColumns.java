package agility.season.controllers;

import java.time.LocalDate;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.LocalDateStringConverter;

public class ResultatsTableColumns {
    private TableColumn<ResultatModel, String> idColumn;
    private TableColumn<ResultatModel, LocalDate> dateColumn;
    private TableColumn<ResultatModel, String> concoursColumn;
    private TableColumn<ResultatModel, String> pointsColumn;
    private TableColumn<ResultatModel, Integer> classementColumn;

    public ResultatsTableColumns(TableView<ResultatModel> table) {
	idColumn = new TableColumn<>("Id");
	idColumn.setCellValueFactory(new PropertyValueFactory<ResultatModel, String>("id"));
	table.getColumns().add(idColumn);

	dateColumn = new TableColumn<>("Date");
	dateColumn.setCellValueFactory(new PropertyValueFactory<ResultatModel, LocalDate>("valueDate"));
	table.getColumns().add(dateColumn);
	formatLocalDateColumn(dateColumn);

	concoursColumn = new TableColumn<>("Concours");
	concoursColumn.setCellValueFactory(new PropertyValueFactory<ResultatModel, String>("concours"));
	table.getColumns().add(concoursColumn);

	pointsColumn = new TableColumn<>("Points");
	pointsColumn.setCellValueFactory(new PropertyValueFactory<ResultatModel, String>("points"));
	table.getColumns().add(pointsColumn);

	classementColumn = new TableColumn<>("Points");
	classementColumn.setCellValueFactory(new PropertyValueFactory<ResultatModel, Integer>("classement"));
	table.getColumns().add(classementColumn);
    }

    private static Callback<TableColumn<ResultatModel, LocalDate>, TableCell<ResultatModel, LocalDate>> forTableColumLocalDate = TextFieldTableCell
	    .<ResultatModel, LocalDate> forTableColumn(new LocalDateStringConverter());

    private void formatLocalDateColumn(TableColumn<ResultatModel, LocalDate> column) {
	column.setCellFactory(forTableColumLocalDate);
	// column.setStyle("-fx-alignment: CENTER-RIGHT;");
    }
}
