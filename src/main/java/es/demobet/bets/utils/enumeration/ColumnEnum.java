package es.demobet.bets.utils.enumeration;

public enum ColumnEnum {

	FIRST_COLUMN("1st12"),
	SECOND_COLUMN("2nd12"),
	THIRD_COLUMN("3rd12");
	
	private String value;
	
	private ColumnEnum (String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
