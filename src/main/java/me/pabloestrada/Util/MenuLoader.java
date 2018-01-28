package me.pabloestrada.Util;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import me.pabloestrada.Converter.ConverterMain;

public class MenuLoader {
private String address;
	
	public MenuLoader(String address) {
		this.address = address;
	}
	public void load() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/" + address + ".fxml"));
		try {
			ConverterMain.getMainStage().setScene(new Scene((Pane)loader.load()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
