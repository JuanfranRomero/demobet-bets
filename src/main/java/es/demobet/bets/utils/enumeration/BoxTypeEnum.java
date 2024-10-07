package es.demobet.bets.utils.enumeration;

import java.util.Arrays;
import java.util.Optional;

public enum BoxTypeEnum {

	NUMBER("number"),
	COLOR("color"), 
	COLUMN("column"),
	ROW("row"),
	HALF("half"),
	PARITY("parity"); 
	
	private String value;
	
	private BoxTypeEnum (String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
    public static BoxTypeEnum byValue(String value) {  
        Optional<BoxTypeEnum> optional = Arrays
        		.stream(values())
        		.filter(boxType -> boxType.getValue().equalsIgnoreCase(value))
        		.findFirst();
        
        return optional.isPresent() ? optional.get() : null;     
    }

}
