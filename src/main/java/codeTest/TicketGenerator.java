package codeTest;

import java.util.Date;

public enum TicketGenerator {
	
	INSTANCE;
	public Ticket generateTicket(Station source, Station destination, TicketType ticketType) {
		if(source == null || destination == null ) {
			throw new IllegalArgumentException("Source and destination can not be null");
		}
		int srcIndex = StationDB.INSTANCE.getIndexOf(source);
		int destIndex = StationDB.INSTANCE.getIndexOf(destination);
		int stops = Math.abs(srcIndex - destIndex);	
		int price = ticketType.getTicketPrice(stops);
		return new Ticket(new Date(), source, destination, stops, price, ticketType);
	}
}
