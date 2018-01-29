package me.pabloestrada.ConverterData;

public class Decimal extends Number {

	public Decimal(String rawText) {
		try {
			setValue("" + Long.parseLong(rawText));
			setValidValue(true);
		} catch (Exception e) {
			setValidValue(false);
		}

	}

	@Override
	public long getDecimalValue() {
		return Long.parseLong(getValue());
	}


}
