package es.demobet.bets.utils;

import java.util.HashMap;
import java.util.List;

import es.demobet.bets.utils.enumeration.BoxTypeEnum;
import es.demobet.bets.utils.enumeration.ColorEnum;
import es.demobet.bets.utils.enumeration.ColumnEnum;
import es.demobet.bets.utils.enumeration.HalfEnum;
import es.demobet.bets.utils.enumeration.ParityEnum;
import es.demobet.bets.utils.enumeration.RowEnum;

public class BoxConstants {

	public static final HashMap<String, String> boxTypesMap = new HashMap<>();
	public static final HashMap<String, List<Integer>> colorMap = new HashMap<>();
	public static final HashMap<String, List<Integer>> columnMap = new HashMap<>();
	public static final HashMap<String, List<Integer>> rowMap = new HashMap<>();
	public static final HashMap<String, List<Integer>> halfMap = new HashMap<>();
	public static final HashMap<String, List<Integer>> parityMap = new HashMap<>();

	    static {
	    	// Numbers
	    	boxTypesMap.put("0", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("1", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("2", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("3", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("4", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("5", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("6", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("7", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("8", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("9", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("10", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("11", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("12", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("13", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("14", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("15", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("16", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("17", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("18", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("19", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("20", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("21", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("22", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("23", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("24", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("25", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("26", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("27", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("28", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("29", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("30", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("31", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("32", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("33", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("34", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("35", BoxTypeEnum.NUMBER.getValue());
	    	boxTypesMap.put("36", BoxTypeEnum.NUMBER.getValue());
	    	// Colors
	    	boxTypesMap.put(ColorEnum.RED.getValue(), BoxTypeEnum.COLOR.getValue());
	    	boxTypesMap.put(ColorEnum.BLACK.getValue(), BoxTypeEnum.COLOR.getValue());
	    	// Columns
	    	boxTypesMap.put(ColumnEnum.FIRST_COLUMN.getValue(), BoxTypeEnum.COLUMN.getValue());
	    	boxTypesMap.put(ColumnEnum.SECOND_COLUMN.getValue(), BoxTypeEnum.COLUMN.getValue());
	    	boxTypesMap.put(ColumnEnum.THIRD_COLUMN.getValue(), BoxTypeEnum.COLUMN.getValue());
	    	// Rows
	    	boxTypesMap.put(RowEnum.FIRST_ROW.getValue(), BoxTypeEnum.ROW.getValue());
	    	boxTypesMap.put(RowEnum.SECOND_ROW.getValue(), BoxTypeEnum.ROW.getValue());
	    	boxTypesMap.put(RowEnum.THIRD_ROW.getValue(), BoxTypeEnum.ROW.getValue());
	    	// Halves
	    	boxTypesMap.put(HalfEnum.FIRST_HALF.getValue(), BoxTypeEnum.HALF.getValue());
	    	boxTypesMap.put(HalfEnum.SECOND_HALF.getValue(), BoxTypeEnum.HALF.getValue());
	    	// Parity
	    	boxTypesMap.put(ParityEnum.EVEN.getValue(), BoxTypeEnum.PARITY.getValue());
	    	boxTypesMap.put(ParityEnum.ODD.getValue(), BoxTypeEnum.PARITY.getValue());
	    	
	    	/* ************************************************************************************************************ */
	    	
	    	colorMap.put(ColorEnum.RED.getValue(), List.of(1, 3, 5, 7, 9, 12, 14, 16, 18, 21, 23, 25, 27, 28, 30, 32, 34, 36));
	    	colorMap.put(ColorEnum.BLACK.getValue(), List.of(2, 4, 6, 8, 10, 11, 13, 15, 17, 19, 20, 22, 24, 26, 29, 31, 33, 35));

	    	columnMap.put(ColumnEnum.FIRST_COLUMN.getValue(), List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
	    	columnMap.put(ColumnEnum.SECOND_COLUMN.getValue(), List.of(13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24));
	    	columnMap.put(ColumnEnum.THIRD_COLUMN.getValue(), List.of(25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36));

	    	rowMap.put(RowEnum.FIRST_ROW.getValue(), List.of(3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36));
	    	rowMap.put(RowEnum.SECOND_ROW.getValue(), List.of(2, 5, 6, 11, 14, 17, 20, 23, 26, 29, 32, 35));
	    	rowMap.put(RowEnum.THIRD_ROW.getValue(), List.of(1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34));

	    	halfMap.put(HalfEnum.FIRST_HALF.getValue(), List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18));
	    	halfMap.put(HalfEnum.SECOND_HALF.getValue(), List.of(19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36));
	    	
	    	parityMap.put(ParityEnum.EVEN.getValue(), List.of(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36));
	    	parityMap.put(ParityEnum.ODD.getValue(), List.of(1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35));
	    }

}
