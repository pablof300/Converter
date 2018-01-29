package me.pabloestrada.ConverterData;

public abstract class Number {
	
	private boolean validValue;
	private String rawValue;
	private String value;
	
	public abstract long getDecimalValue();

	public String getRawValue() {
		return rawValue;
	}
	public void setRawValue(String rawValue) {
		this.rawValue = rawValue;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isValid() {
		return validValue;
	}
	public void setValidValue(boolean validValue) {
		this.validValue = validValue;
	}
}
