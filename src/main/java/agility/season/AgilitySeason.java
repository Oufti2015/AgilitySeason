package agility.season;

import java.io.File;
import java.io.IOException;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import agility.season.controllers.MainController;
import agility.season.utils.NewResultatChange;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j;

@Log4j
public class AgilitySeason extends Application {
    public static EventBus eventBus = new EventBus();

    private static final String VIEWS_MAIN_FXML = "views/Main.fxml";

    private AnchorPane rootLayout;
    private Stage primaryStage;

    private AgilityData data;
    AgilityDataFile adf = new AgilityDataFile("data.json");

    public static void main(String[] args) {
	launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
	data = adf.load();

	// set title
	this.primaryStage = primaryStage;
	primaryStage.setTitle("Agility Season");

	initRootLayout();
	// primaryStage.setMaximized(true);
	// primaryStage.setFullScreen(true);
	Scene scene = primaryStage.getScene();
	File f = new File("agility.css");
	scene.getStylesheets().clear();
	scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
    }

    /**
     * Initializes the root layout.
     */
    private void initRootLayout() {
	eventBus.register(this);
	try {
	    // Load root layout from fxml file.
	    FXMLLoader loader = null;
	    loader = new FXMLLoader();
	    loader.setLocation(AgilitySeason.class.getResource(VIEWS_MAIN_FXML));
	    rootLayout = (AnchorPane) loader.load();

	    MainController controller = loader.getController();
	    controller.setOwner(this);
	    controller.setData(data.getChiens());
	    // Show the scene containing the root layout.
	    Scene scene = new Scene(rootLayout);
	    primaryStage.setScene(scene);
	    primaryStage.show();

	} catch (IOException e) {
	    System.err.println("Cannot load " + VIEWS_MAIN_FXML + " : " + e);
	    e.printStackTrace();
	}
    }

    @Subscribe
    public void handleEvent(NewResultatChange e) {
	log.info("" + data + " has changed.");
	adf.save(data);
    }

}
