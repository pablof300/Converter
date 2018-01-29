package me.pabloestrada.Converter;

import javafx.application.Application;
import javafx.stage.Stage;
import me.pabloestrada.Util.MenuLoader;

public class ConverterMain extends Application {

	private static Stage mainStage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		mainStage = stage;
		new MenuLoader("convertermenu").load();
		mainStage.setResizable(false);
		mainStage.show();
		mainStage.setTitle("Converter by Pablo");
		
		System.out.println("1011111031".matches("[01]+"));
	}

	public static Stage getMainStage() {
		return mainStage;
	}
}
