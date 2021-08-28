import java.util.*;
public class ParkingValet {

	public static void main(String[] args) {
		ParkingArea spots[] = new ParkingArea[52];
		boolean referencesUsed[] = new boolean[100];
		
		for(int i = 0; i < 52; i++) {
			spots[i] = new ParkingArea();
		}
		
		Scanner reader = new Scanner(System.in);
		
		boolean breakLoop = true;
		while(breakLoop) {
			System.out.println("What would you like to do?");
			System.out.println("Enter 1 to know how many parking spots are available, 2 to drop a car off, 3 to pick up a car, or 4 to exit the program");
			int userChoice = 5;
			
			while((userChoice > 4) || (userChoice < 1)) {
				userChoice = reader.nextInt();
				
				if((userChoice > 4) || (userChoice < 1)) {
					System.out.println("Invalid input. Please enter 1, 2, 3, or 4");
				}
			}
			
			loop1: switch(userChoice) {
				case 1:
				{
					int spotsAvailable = 0;
					for(int i = 0; i < 52; i++) {
						if(spots[i].getUsed() == false) {
							spotsAvailable++;
						}
					}
					System.out.println("There are " + spotsAvailable + " spots available");
					break;
				}
				case 2:
				{
					boolean freeSpots = false;
					for(int i = 0; i < 52; i++) {
						if(spots[i].getUsed() == false) {
							freeSpots = true;
						}
					}
					
					if(freeSpots == false) {
						System.out.println("No more spots available");
						break loop1;
					}
					
					int referenceFiller = 0;
					for(int i = 0; i < 100; i++) {
						if(referencesUsed[i] == false) {
							referenceFiller = i;
							referencesUsed[i] = true;
							break;
						}
					}
					
					for(int i = 0; i < 52; i++) {
						if(spots[i].getUsed() == false) {
							String licenseFiller = "LICENSE FILLER";
							
							while(licenseFiller.length() > 7) {
								System.out.println("Enter license plate. Max characters: 7");
								licenseFiller = reader.next();
							}
							
							spots[i].changeUsed(true);
							spots[i].changeReferenceNumber(referenceFiller);
							spots[i].changeLicensePlate(licenseFiller);
							
							System.out.println("Your car will be parked in spot number " + (i + 100));
							System.out.println("Your reference number is: " + spots[i].getReferenceNumber());
							
							break;
						}
					}
					break;
				}
				case 3:
				{
					System.out.println("Enter reference number");
					int userReference = reader.nextInt();
					
					for(int i = 0; i < 52; i++) {
						if(spots[i].getReferenceNumber() == userReference) {
							System.out.println("Your car is at parking spot " + (i + 100));
							System.out.println("License plate of car at requested spot: " + spots[i].getLicensePlate());
							
							referencesUsed[userReference] = false;
							spots[i].changeLicensePlate("");
							spots[i].changeUsed(false);
							spots[i].changeReferenceNumber(-1);
							
							break loop1;
						}
					}
					System.out.println("Requested reference number could no be found. Please enter a different reference number next time.");
					break;
				}
				case 4:
				{
					breakLoop = false;
				}
			}
		}
		
		System.out.println("Thank you for using this program. Have a nice day!");
		reader.close();
		return;

	}

}
