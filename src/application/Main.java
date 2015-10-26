package application;
	
import java.io.File;
import java.io.IOException;

import application.RootPokerController;
import application.Main;
import application.PokerTableController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	 private Stage primaryStage;
	 private BorderPane rootPoker;
	@Override
	public void start(Stage primaryStage) {
		 this.primaryStage = primaryStage;
		 this.primaryStage.setTitle("PokerApp");

		 // Set the application icon.
		 this.primaryStage.getIcons().add(new Image("file:resources/images/address_book_32.png"));

		 initRootPoker();

		 showPokerTable();
		    }

    /**
     * Initializes the root layout and tries to load the last opened
     * person file.
     */
    public void initRootPoker() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class
                    .getResource("RootPoker.fxml"));
            rootPoker = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootPoker);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootPokerController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
    public void showPokerTable() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("PokerTable.fxml"));
            AnchorPane pokerTable = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootPoker.setCenter(pokerTable);

            // Give the controller access to the main app.
            PokerTableController controller = loader.getController();
            controller.setMainApp(this);

       } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
