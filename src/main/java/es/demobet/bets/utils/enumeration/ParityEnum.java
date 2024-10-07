package es.demobet.bets.utils.enumeration;

public enum ParityEnum {

	EVEN("Even"),
	ODD("Odd");
	
	private String value;
	
	private ParityEnum (String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
