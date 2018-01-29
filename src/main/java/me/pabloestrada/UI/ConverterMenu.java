package me.pabloestrada.UI;

import java.util.HashMap;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;
import me.pabloestrada.Converter.ConverterMain;
import me.pabloestrada.ConverterData.Binary;
import me.pabloestrada.ConverterData.DataType;
import me.pabloestrada.ConverterData.Decimal;
import me.pabloestrada.ConverterData.Hexadecimal;
import me.pabloestrada.ConverterData.Number;
import me.pabloestrada.ConverterData.Octal;

public class ConverterMenu {

	@FXML
	private TextField input;

	@FXML
	private Text selectedInput;
	@FXML
	private Text status;

	private DataType selectedDataType;

	@FXML
	private ImageView decimal;
	@FXML
	private ImageView binary;
	@FXML
	private ImageView hexadecimal;
	@FXML
	private ImageView octal;

	@FXML
	private Text decimalText;
	@FXML
	private Text binaryText;
	@FXML
	private Text hexadecimalText;
	@FXML
	private Text octalText;

	private HashMap<ImageView, DataType> imageToType;
	private InputListener inputListener;

	@SuppressWarnings("unchecked")
	@FXML
	private void initialize() {
		imageToType = new HashMap<ImageView, DataType>();
		selectedDataType = DataType.DECIMAL;
		inputListener = new InputListener(this);
		input.textProperty().addListener(inputListener);
		ImageView[] views = { decimal, binary, hexadecimal, octal };
		DataType[] types = { DataType.DECIMAL, DataType.BINARY, DataType.HEXADECIMAL, DataType.OCTAL };
		for (int i = 0; i < views.length; i++)
			imageToType.put(views[i], types[i]);
	}
	
	@FXML
	private void updateType(MouseEvent event) {
		ImageView clickedImage = (ImageView) event.getSource();
		selectedDataType = imageToType.get(clickedImage);
		updateImageViews(clickedImage);
		selectedInput.setText(selectedDataType.getTitle());
		updateDataTypes();
	}

	private void updateImageViews(ImageView selectedImage) {
		ImageView[] views = { decimal, binary, hexadecimal, octal };
		for (ImageView view : views) {
			boolean fadeIn = false;
			if (view.equals(selectedImage))
				fadeIn = true;
			fadeImage(fadeIn, view);
		}
	}

	private void fadeImage(boolean fadeIn, ImageView image) {
		float scale = 0.5f;
		if (fadeIn)
			scale = 1;
		FadeTransition ft = new FadeTransition(Duration.millis(500), image);
		ft.setToValue(scale);
		ft.setCycleCount(1);
		ft.play();
	}

	public void updateDataTypes() {
		if (input.getText().isEmpty()) {
			updateStatusText(true);
			updateAll();
			return;
		}
		Number number = null;
		if (selectedDataType == DataType.DECIMAL)
			number = new Decimal(input.getText());
		if (selectedDataType == DataType.BINARY)
			number = new Binary(input.getText());
		if (selectedDataType == DataType.HEXADECIMAL)
			number = new Hexadecimal(input.getText());
		if (selectedDataType == DataType.OCTAL)
			number = new Octal(input.getText());
		updateStatusText(number.isValid());
		if (number.isValid())
			updateAll(number.getDecimalValue());
		else
			updateAll();
	}

	private void updateStatusText(boolean valid) {
		if (valid) {
			status.setText("");
			return;
		}
		status.setText("The value you have inputed is not valid!");
	}

	private void updateAll(long decimalValue) {
		decimalText.setText("" + decimalValue);
		binaryText.setText("" + new Binary(decimalValue).getValue());
		hexadecimalText.setText("" + new Hexadecimal(decimalValue).getValue());
		octalText.setText("" + new Octal(decimalValue).getValue());
	}

	private void updateAll() {
		decimalText.setText("");
		binaryText.setText("");
		hexadecimalText.setText("");
		octalText.setText("");
	}

	public DataType getSelectedDataType() {
		return selectedDataType;
	}

}
