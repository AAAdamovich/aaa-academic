// Anton Adamovich
// Mr. Meistering
// Advanced Topics in Computer Science Honors
// 9-6-2013
// "Airline Reservations" Lab

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class ReservationsDriver {

		public static void main(String[] args) throws IOException{
			
			// Variable Declarations & Object Instantiations
			
			Reservations reservations;
			String command = "";
			String userName;
			Scanner stringReader = new Scanner(System.in);
			
			// Main Code
			
			System.out.println("Welcome to ReserveYourSeat v1.0, this program allows\n" +
					"you to reserve seat(s) on your airplane flight, view current\n" +
					"seating arrangements, cancel a reservation, as well as other\n" +
					"things. You may type \"Help\" for a list of commands. \"Exit\"\n" +
					"will exit the program. Please enjoy your flight!\n");
			System.out.print("Please enter your name: ");
			userName = stringReader.nextLine();
			reservations = new Reservations(userName);
			reservations.readReservationsFromFile();
			System.out.println("\nReserve Seat: Allows you to reserve a single seat on the flight.");
			System.out.println("Reserve Row: Allows you to reserve a row of up to four(4) seats.");
			System.out.println("Cancel Reservation: Allows you to cancel your reservation.");
			System.out.println("Show Layout: Shows a layout of the plane, detailing all of the\n" +
					"currently reserved/non reserved seats.");
			System.out.println("Show Reservations: Shows all current reservations by user. ");
			while(!(command.equalsIgnoreCase("exit"))){
				// For very specific spacing
				System.out.println("");
				System.out.print("Please enter an action: ");
				command = stringReader.nextLine();
				System.out.println("");
				if(!(runCommand(reservations, command, userName))){
					System.out.println("\nYour input is invalid, please check your spelling and/or\n" +
							"format and try again. You may enter \"Help\" for a list of commands. ");
				}	
			}
			reservations.printReservationsToFile();
			System.out.println("Thank you for using ReserveYourSeat v1.0, have a nice day!");
		}
		
		private static boolean runCommand(Reservations reservations, String command, String userName){
			Scanner stringReader = new Scanner(System.in);
			Scanner reader = new Scanner(System.in);
			String seat;
			if(command.equalsIgnoreCase("help")){
				System.out.println("Help: Displays a list of all the commands.");
				System.out.println("Reserve Seat: Allows you to reserve a single seat on the flight.");
				System.out.println("Reserve Row: Allows you to reserve a row of up to four(4) seats.");
				System.out.println("Cancel Reservation: Allows you to cancel your reservation.");
				System.out.println("Show Layout: Shows a layout of the plane, detailing all of the\n" +
						"currently reserved/non reserved seats.");
				System.out.println("Show Reservations: Shows all current reservations by user. ");
				System.out.println("Exit: Exits the program. ");
				return true;
			}
			if(command.equalsIgnoreCase("reserve seat")){
				reservations.printLayout();
				// For spacing
				System.out.println("");
				System.out.print("Please enter the seat you would like to reserve in the format" +
						" \"##E\",\nwhere 'E' denotes the column letter and #'s are numbers: ");
				seat = stringReader.nextLine();
				if(!(reservations.checkInput(seat))) return false;
				if(reservations.reserveSeat(Seat.toObject(seat))) System.out.println("\nReservation successful. ");
				return true;
			}
			// Precondition: "row" must be an "int"
			if(command.equalsIgnoreCase("reserve row")){
				int row;
				Seat openSeat;
				String reservationList[][] = (reservations.getReservations());
				ArrayList<Seat> openSeats = new ArrayList<Seat>();
				reservations.printLayout();
				// For spacing
				System.out.println("");
				System.out.print("A row of seats can be reserved, please enter the number\n" +
						"of the row you would like to reserve: ");
				row = reader.nextInt();
				if ((row <= 0) || (row > 40)) return false;
				row--;
				for(int i = 0; i < 4; i++){
					if(!((reservationList[row][i]) != null)){
						openSeat = new Seat((row + 1), i);
						openSeats.add(openSeat);
					}
				}
				if((openSeats.size()) <= 1){
					System.out.println("That row has less than two seats availible, it cannot\n" +
							"be reserved as a row, try reserving a single seat instead. ");
					return true;
				}
				for(Seat seatToReserve : openSeats){
					reservations.reserveSeat(seatToReserve);
				}
				System.out.println("Reservations successful.");
				return true;
			}
			if(command.equalsIgnoreCase("show layout")){
				reservations.printLayout();
				return true;
			}
			if(command.equalsIgnoreCase("show reservations")){
					reservations.printReservations();
					return true;
			}
			if(command.equalsIgnoreCase("cancel reservation")){
				reservations.printReservations();
				System.out.println("Please enter the reserved seat you would like to cancel in the" +
						" format \"##E\",\nwhere 'E' denotes the column letter. ");
				seat = stringReader.nextLine();
				if(!(reservations.checkInput(seat))) return false;
				if(reservations.checkIdentity(userName)) reservations.cancelSeat(Seat.toObject(seat));
				else System.out.println("You do not have that seat reserved. ");
				return true;
			}
			if(command.equalsIgnoreCase("exit")) return true;
			return false;
		}
}
