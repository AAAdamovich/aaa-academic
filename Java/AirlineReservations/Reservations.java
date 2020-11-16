// Anton Adamovich
// Mr. Meistering
// Advanced Topics in Computer Science Honors
// 9-6-2013
// "Airline Reservations" Lab

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Reservations {

	private String[][] reservations;
	private String currentUser;

	public Reservations(String userName){
		currentUser = userName;
		reservations = new String[40][4];
		// Explicit assignment of "null" for all Strings in reservations list
		for(int i = 0; i < reservations.length; i++){
			for(int u = 0; u < (reservations[i].length); u++){
				reservations[i][u] = null;
			}
		}
	}
	
	public String[][] getReservations(){
		return reservations;
	}
	
	public void printLayout(){
		System.out.println("Here is a list of all currently reserved and non-reserved seats. ");
		System.out.println("Dashes are open, X'es are taken.\nCurrent Seating:\n\nSeat:   A B C D");
		for(int i = 0; i < reservations.length; i++){
			// For consistent spacing
			if(i < 9) System.out.print("Row " + (i + 1) + ":  ");
			else System.out.print("Row " + (i + 1) + ": ");
			for(int u = 0; u < (reservations[i].length); u++){
				if((reservations[i][u]) != null) System.out.print("X ");
				else System.out.print("- ");
			}
			// For spacing
			System.out.println("");
		}
	}
	
	public void printReservations(){
		Seat reservedSeat;
		System.out.println("Here is a list of all your current reservations: ");
		for(int i = 0; i < reservations.length; i++){
			for(int u = 0; u < (reservations[i].length); u++){
				if(((reservations[i][u]) != null) && ((reservations[i][u]).equalsIgnoreCase(currentUser))){
					reservedSeat = new Seat((i + 1), u);
					System.out.println((reservedSeat.toString()));
				}
			}
		}
	}

	public void printReservationsToFile() throws IOException{
		try{
			Seat reservedSeat;
			File reservationFile = new File("reservationFile.txt");
			FileWriter fWriter = new FileWriter(reservationFile);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			for(int i = 0; i < 40; i++){
				for(int u = 0; u < 4; u++){
					if((reservations[i][u]) != null){
						reservedSeat = new Seat(i, u);
						bWriter.write(reservedSeat.toString());
						bWriter.newLine();
						bWriter.write(reservations[i][u]);
						bWriter.newLine();
						bWriter.flush();
					}
				}
			}
			bWriter.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void readReservationsFromFile() throws IOException{
		try{
			File reservationFile = new File("reservationFile.txt");
			Scanner fileReader = new Scanner(reservationFile);
			String reservedSeat;
			String user;
			while(fileReader.hasNext()){
				reservedSeat = fileReader.nextLine();
				Seat classSeat = Seat.toObject(reservedSeat);
				user = fileReader.nextLine();
				(reservations[classSeat.getRow()][classSeat.getColumn()]) = user;
			}
			fileReader.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public boolean checkIdentity(String user){
		if(user.equals(currentUser)) return true;
		else return false;
	}
	
	public boolean checkInput(String seat){
		int row;
		char charColumn;
		int length = seat.length();
		if ((length > 3) || (length < 2)) return false;
		row = (Integer.parseInt(seat.substring(0, (length - 1))));
		if ((row <= 0) || (row > 40)) return false;
		seat = (seat.toUpperCase());
		charColumn = seat.charAt(length - 1);
		if (((charColumn == 'A') || (charColumn == 'B')) || ((charColumn == 'C') || 
				(charColumn == 'D'))) return true;
		else return false;
	}
	
	public boolean reserveSeat(Seat aSeat){
		if(!((reservations[(aSeat.getRow() - 1)][aSeat.getColumn()]) != null)){
			(reservations[(aSeat.getRow() - 1)][aSeat.getColumn()]) = currentUser;
			return true;
		}
		else{
			System.out.println("Reservation failed, that seat is taken. ");
			return false;
		}
	}
	
	public boolean cancelSeat(Seat aSeat){
		if((reservations[(aSeat.getRow() - 1)][aSeat.getColumn()]) != null){
			if((reservations[(aSeat.getRow() - 1)][aSeat.getColumn()]).equalsIgnoreCase(currentUser)){
				(reservations[(aSeat.getRow() - 1)][aSeat.getColumn()]) = null;
				System.out.println("Cancellation successful. ");
				return true;
			}
			else{
				System.out.println("Cancellation failed, that is not one of your reserved seats. ");
				return false;
			}
		}
		else{
			System.out.println("Cancellation failed, that seat is currently open. ");
			return false;
		}
	}
}
