package es.demobet.bets.utils.enumeration;

public enum RowEnum {
	
	FIRST_ROW("3-36"),
	SECOND_ROW("2-35"),
	THIRD_ROW("1-34");
	
	private String value;
	
	private RowEnum (String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
