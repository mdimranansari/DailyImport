
public class Ticket {

	public static final int AVAILABLE_TICKETS = 30;
	public static final String CSV_PATH = "C:/Employee_Leaves_Report.csv";
	
	private static int ticketSold;
	private String seatNumber;

	/**
	 * @return the seatNumber
	 */
	public String getSeatNumber() {
		return seatNumber;
	}

	/**
	 * @param seatNumber the seatNumber to set
	 */
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	/**
	 * @return the ticketSold
	 */
	public int getTicketSold() {
		return ticketSold;
	}

	/**
	 * @param ticketSold the ticketSold to set
	 */
	public void setTicketSold(int ticketSold) {
		this.ticketSold = ticketSold;
	}

	public int getTotalTicketAvailable() {
		return AVAILABLE_TICKETS;
	}

	public int getTicketAvailable() {
		return AVAILABLE_TICKETS - ticketSold;
	}
}
