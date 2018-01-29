package me.pabloestrada.UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class InputListener implements ChangeListener {

	private ConverterMenu menu;
	
	public InputListener(ConverterMenu menu) {
		this.menu = menu;
	}
	
	public void changed(ObservableValue arg0, Object arg1, Object arg2) {
		menu.updateDataTypes();
	}

}
