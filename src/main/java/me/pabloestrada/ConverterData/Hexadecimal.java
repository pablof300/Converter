package me.pabloestrada.ConverterData;

public class Hexadecimal extends Number {
	public Hexadecimal(String rawText) {
		try {
			Long.parseLong(rawText, 16);
			setValue(rawText);
			setValidValue(true);
		} catch (Exception e) {
			setValidValue(false);
		}
	}

	public Hexadecimal(long decimalValue) {
		setValue(Long.toString(decimalValue, 16));
		setValidValue(true);

	}

	@Override
	public long getDecimalValue() {
		long decimalValue = 999999999;
		if (isValid())
			decimalValue = Long.parseLong("" + getValue(), 16);
		return decimalValue;
	}

}
