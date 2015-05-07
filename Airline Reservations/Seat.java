// Anton Adamovich
// Mr. Meistering
// Advanced Topics in Computer Science Honors
// 9-10-2013
// "Airline Reservations" Lab

// When entering integer fields for this object, this project implementation 
// is used in such a way that integers for the "row" variable must be one higher than 
// their proper index in the "reservations" list. 

public class Seat {
	
	private int row;
	private int column;
	
	public Seat(int aRow, int aColumn){
		row = aRow;
		column = aColumn;
	}
	
	public Seat(){
		row = -1;
		column = -1;
	}

	public int getRow() {
		return row;
	}
	
	public void setRow(int aRow){
		row = aRow;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int aColumn) {
		column = aColumn;
	}

	public void setSeat(int aRow, char aColumn){
		row = aRow;
		column = aColumn;
	}
	
	public static Seat toObject(String aSeat){
		Seat objectSeat = new Seat();
		char charColumn;
		int length = aSeat.length();
		objectSeat.setRow(Integer.parseInt(aSeat.substring(0, (length - 1))));
		aSeat = (aSeat.toUpperCase());
		charColumn = aSeat.charAt(length - 1);
		if (charColumn == 'A') objectSeat.setColumn(0);
		else if (charColumn == 'B') objectSeat.setColumn(1);
		else if (charColumn == 'C') objectSeat.setColumn(2);
		else if (charColumn == 'D') objectSeat.setColumn(3);
		return objectSeat;
	}
	
	public String toString(){
		String returnable = "";
		char charValue = '*';
		if (column == 0) charValue = 'A';
		else if (column == 1) charValue = 'B';
		else if (column == 2) charValue = 'C';
		else if (column == 3) charValue = 'D';
		returnable += (row);
		returnable += (charValue);
		return returnable;
	}
}
