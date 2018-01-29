package me.pabloestrada.ConverterData;

public enum DataType {

	DECIMAL("Decimal"),BINARY("Binary"),OCTAL("Octal"),HEXADECIMAL("Hexadecimal");
	
	private String title;
	
	private DataType(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
}
