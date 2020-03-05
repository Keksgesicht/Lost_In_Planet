package io.gui.game;

import io.gui.game.map.MapScene;
import javafx.application.Application;
import javafx.stage.Stage;
import test.TestDataCreator;

public class GameStage extends Application {

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
		mapScene = new MapScene(1900, 1000);
		primaryStage.setScene(mapScene);
		primaryStage.show();
		TestDataCreator.createData(this);
	}

	public MapScene getMapScene() {
		return mapScene;
	}

}
