package io.gui.stages;

import io.gui.scenes.MapScene;
import javafx.application.Application;
import javafx.stage.Stage;
import test.TestDataCreator;

public class Main extends Application {

	private MapScene mapScene;

	/*
	 * here starts our Programm
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Lost in Planet");
		mapScene = new MapScene(550, 550);
		primaryStage.setScene(mapScene);
		primaryStage.show();
		TestDataCreator.createData(this);
	}

	public MapScene getMapScene() {
		return mapScene;
	}

}
