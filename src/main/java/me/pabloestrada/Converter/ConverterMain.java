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
		new MenuLoader("convertor").load();
		mainStage.setResizable(false);
		mainStage.show();
		mainStage.setTitle("Convertor");
	}

	public static Stage getMainStage() {
		return mainStage;
	}
}
