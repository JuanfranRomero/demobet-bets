package es.demobet.bets.utils.enumeration;

public enum ColorEnum {

	RED("Red"),
	BLACK("Black");
	
	private String value;
	
	private ColorEnum (String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
