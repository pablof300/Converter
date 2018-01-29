package me.pabloestrada.ConverterData;

public class Octal extends Number {
	public Octal(String rawText) {
		try {
			Long.parseLong(rawText, 8);
			setValue(rawText);
			setValidValue(true);
		} catch (Exception e) {
			setValidValue(false);
		}
	}

	public Octal(long decimalValue) {
		try {
			setValue("" + Long.toString(decimalValue, 8));
			setValidValue(true);
		} catch (Exception e) {
			setValidValue(false);
		}
	}

	@Override
	public long getDecimalValue() {
		long decimalValue = 999999999;
		if (isValid()) {
			System.out.println(Long.parseLong("" + getValue(), 8));
			decimalValue = Long.parseLong("" + getValue(), 8);
		}
		return decimalValue;
	}
}
