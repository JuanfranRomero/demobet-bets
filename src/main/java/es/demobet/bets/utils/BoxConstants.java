package es.demobet.bets.utils;

import java.util.HashMap;
import java.util.List;

public class BoxConstants {

	public static final HashMap<String, String> boxTypesMap = new HashMap<>();
	public static final HashMap<String, List<Integer>> colorMap = new HashMap<>();
	public static final HashMap<String, List<Integer>> columnMap = new HashMap<>();
	public static final HashMap<String, List<Integer>> rowMap = new HashMap<>();
	public static final HashMap<String, List<Integer>> halfMap = new HashMap<>();
	public static final HashMap<String, List<Integer>> parityMap = new HashMap<>();

	    static {
	    	// Numbers
	    	boxTypesMap.put("0", "number");
	    	boxTypesMap.put("1", "number");
	    	boxTypesMap.put("2", "number");
	    	boxTypesMap.put("3", "number");
	    	boxTypesMap.put("4", "number");
	    	boxTypesMap.put("5", "number");
	    	boxTypesMap.put("6", "number");
	    	boxTypesMap.put("7", "number");
	    	boxTypesMap.put("8", "number");
	    	boxTypesMap.put("9", "number");
	    	boxTypesMap.put("10", "number");
	    	boxTypesMap.put("11", "number");
	    	boxTypesMap.put("12", "number");
	    	boxTypesMap.put("13", "number");
	    	boxTypesMap.put("14", "number");
	    	boxTypesMap.put("15", "number");
	    	boxTypesMap.put("16", "number");
	    	boxTypesMap.put("17", "number");
	    	boxTypesMap.put("18", "number");
	    	boxTypesMap.put("19", "number");
	    	boxTypesMap.put("20", "number");
	    	boxTypesMap.put("21", "number");
	    	boxTypesMap.put("22", "number");
	    	boxTypesMap.put("23", "number");
	    	boxTypesMap.put("24", "number");
	    	boxTypesMap.put("25", "number");
	    	boxTypesMap.put("26", "number");
	    	boxTypesMap.put("27", "number");
	    	boxTypesMap.put("28", "number");
	    	boxTypesMap.put("29", "number");
	    	boxTypesMap.put("30", "number");
	    	boxTypesMap.put("31", "number");
	    	boxTypesMap.put("32", "number");
	    	boxTypesMap.put("33", "number");
	    	boxTypesMap.put("34", "number");
	    	boxTypesMap.put("35", "number");
	    	boxTypesMap.put("36", "number");
	    	// Colors
	    	boxTypesMap.put("Red", "color");
	    	boxTypesMap.put("Black", "color");
	    	// Columns
	    	boxTypesMap.put("1st12", "column");
	    	boxTypesMap.put("2nd12", "column");
	    	boxTypesMap.put("3rd12", "column");
	    	// Rows
	    	boxTypesMap.put("3-36", "row");
	    	boxTypesMap.put("2-35", "row");
	    	boxTypesMap.put("1-34", "row");
	    	// Halves
	    	boxTypesMap.put("1-18", "half");
	    	boxTypesMap.put("19-36", "half");
	    	// Parity
	    	boxTypesMap.put("Even", "parity");
	    	boxTypesMap.put("Odd", "parity");
	    	
	    	/* ******************************************************** */
	    	colorMap.put("Red", List.of(1, 3, 5, 7, 9, 12, 14, 16, 18, 21, 23, 25, 27, 28, 30, 32, 34, 36));
	    	colorMap.put("Black", List.of(2, 4, 6, 8, 10, 11, 13, 15, 17, 19, 20, 22, 24, 26, 29, 31, 33, 35));

	    	columnMap.put("1st12", List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
	    	columnMap.put("2nd12", List.of(13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24));
	    	columnMap.put("3rd12", List.of(25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36));

	    	rowMap.put("3-36", List.of(3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36));
	    	rowMap.put("2-35", List.of(2, 5, 6, 11, 14, 17, 20, 23, 26, 29, 32, 35));
	    	rowMap.put("1-34", List.of(1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34));

	    	halfMap.put("1-18", List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18));
	    	halfMap.put("19-36", List.of(19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36));
	    	
	    	parityMap.put("Even", List.of(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36));
	    	parityMap.put("Odd", List.of(1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35));
	    }

}
