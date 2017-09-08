package agility.season;

import java.io.IOException;

import agility.season.controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AgilitySeason extends Application {
    private static final String VIEWS_MAIN_FXML = "views/Main.fxml";

    private AnchorPane rootLayout;
    private Stage primaryStage;

    private AgilityData data = new AgilityData();

    public static void main(String[] args) {

	launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

	// OuftiBankFX.eventBus.post(new Exception("Test"));

	// set title
	this.primaryStage = primaryStage;
	primaryStage.setTitle("Oufti Bank");

	initRootLayout();
	// primaryStage.setMaximized(true);
	// primaryStage.setFullScreen(true);
	// Scene scene = primaryStage.getScene();
	// File f = new File("bankFX.css");
	// scene.getStylesheets().clear();
	// scene.getStylesheets().add("file:///" +
	// f.getAbsolutePath().replace("\\", "/"));

	// InputStream resourceAsStream =
	// AgilitySeason.class.getResourceAsStream(ICON);
	// if (resourceAsStream != null) {
	// primaryStage.getIcons().add(new Image(resourceAsStream));
	// } else {
	// log.error("Cannot load icon <" + ICON + ">");
	// primaryStage.getIcons().add(new Image("euro3.png"));
	// }

    }

    /**
     * Initializes the root layout.
     */
    private void initRootLayout() {
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
}
