package me.pabloestrada.ConverterData;

public class Binary extends Number {

	public Binary(String rawText) {
		if (!rawText.matches("[01]+")) {
			setValidValue(false);
		} else {
			setValue(rawText);
			setValidValue(true);
		}
	}

	public Binary(long decimalValue) {
		setValue(Long.toString(decimalValue, 2));
		setValidValue(true);

	}

	@Override
	public long getDecimalValue() {
		long decimalValue = 999999999;
		if (isValid())
			decimalValue = Long.parseLong("" + getValue(), 2);
		return decimalValue;
	}

}
