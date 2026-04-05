import java.util.*;

public class Motel {

	private int motelId;
	private String motelName;
	private String dateOfBooking;
	private int noOfRoomsBooked;
	private String cabFacility;
	private double totalBill;

	// Getter and Setter
	public int getMotelId() {
		return this.motelId;
	}
	public void setMotelId(int motelId) {
		this.motelId = motelId;
	}
	public String getMotelName() {
		return this.motelName;
	}
	public void setMotelName(String motelName) {
		this.motelName = motelName;
	}

	public String getDateOfBooking() {
		return this.dateOfBooking;
	}
	public void setDateOfBooking(String dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	public int getNoOfRoomBooked() {
		return this.noOfRoomsBooked;
	}
	public void setNoOfRoomBooked(int noOfRoomsBooked) {
		this.noOfRoomsBooked = noOfRoomsBooked;
	}
	public String getCabFacility() {
		return this.cabFacility;
	}
	public void setCabFacility(String cabFacility) {
		this.cabFacility = cabFacility;
	}
	public double getTotalBill() {
		return this.totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	public Motel(int motelId, String motelName, String dateOfBooking, int noOfRoomsBooked, String cabFacility, double bill) {
		this.motelId = motelId;
		this.motelName = motelName;
		this.dateOfBooking = dateOfBooking;
		this.noOfRoomsBooked = noOfRoomsBooked;
		this.cabFacility = cabFacility;
		this.totalBill = bill;
	}
	public static int totalNoOfRoomsBooked(Motel[] motels, String cab) {
		int cnt = 0;
		for (int i = 0; i < motels.length; i++) {
			if (motels[i].getCabFacility().equals(cab) && motels[i].getNoOfRoomBooked() > 5) {
				cnt += motels[i].getNoOfRoomBooked();
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Motel[] motels = new Motel[4];
		int ind = 0;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			int motelid = sc.nextInt();
			sc.nextLine();
			String motelname = sc.nextLine();
			String dateOfBookings = sc.nextLine();
			int noOfRoomsBooked = sc.nextInt();
			sc.nextLine();
			String cabfacility = sc.nextLine();
			double totalBill = sc.nextDouble();
			sc.nextLine();
			motels[ind++] = new Motel(motelid, motelname, dateOfBookings, noOfRoomsBooked, cabfacility, totalBill);
		}
		String cab = sc.nextLine();
		int cnt = totalNoOfRoomsBooked(motels, cab);
		// if (cnt == 0){
		// 	System.out.println("");
		// }
		System.out.println(cnt);
		sc.close();
	}

}

