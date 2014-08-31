import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;


public class RunTicketBooking {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Ticket ticket = new Ticket();
		
		initialize(ticket);
		
		while (true){
			displayChoices(ticket);
		}
	}

	public static void displayChoices(Ticket ticket){
		
		System.out.println("\n\n\nTotal tickets: " + ticket.getTotalTicketAvailable());
		System.out.println("Sold tickets: " + ticket.getTicketSold());
		System.out.println("Available tickets: " + ticket.getTicketAvailable());
		System.out.println("Menu Options: ");
		System.out.println("\t\t1. Reserve ticket");
		System.out.println("\t\t1. Reserve ticket");
		System.out.println("\t\t1. Reserve ticket");
		System.out.println("\t\t1. Reserve ticket");
	}
	
	public static void initialize (Ticket ticket){
		try{
			DataInputStream dis= new DataInputStream(new FileInputStream (Ticket.CSV_PATH));
			String record;
			ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
			while ((record = dis.readLine()) != null){
				String strArr[] = record.split(",");
				Ticket tmpTicket= new Ticket();
				ticketList.add(tmpTicket);
				tmpTicket.setSeatNumber(strArr[0]);
				tmpTicket.setTicketSold(tmpTicket.getTicketSold() - 1);
			}
		}catch (Exception e){
			// do nothing
		}
	}
}
