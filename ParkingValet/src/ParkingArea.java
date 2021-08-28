
public class ParkingArea {
	private boolean used;
	private int referenceNumber;
	private String licensePlate;
	
	public ParkingArea() {
		used = false;
		referenceNumber = -1;
		licensePlate = "";
	}
	
	public boolean getUsed() {
		return used;
	}
	
	public int getReferenceNumber() {
		return referenceNumber;
	}
	
	public String getLicensePlate() {
		return licensePlate;
	}
	
	public void changeUsed(boolean x) {
		used = x;
	}
	
	public void changeReferenceNumber(int x) {
		referenceNumber = x;
	}
	
	public void changeLicensePlate(String x) {
		licensePlate = x;
	}
}
