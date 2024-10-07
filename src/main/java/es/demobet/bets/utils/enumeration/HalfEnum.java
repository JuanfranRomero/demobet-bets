package es.demobet.bets.utils.enumeration;

public enum HalfEnum {

	FIRST_HALF("1-18"),
	SECOND_HALF("19-36");
	
	private String value;
	
	private HalfEnum (String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
