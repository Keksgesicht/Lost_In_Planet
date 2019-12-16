package io.gui.stages;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	/*
	 * here starts our Programm
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("myWindow");
		StackPane layout = new StackPane();
		Scene testScene = new Scene(layout, 300, 250);
		primaryStage.setScene(testScene);
		primaryStage.show();
	}

}
