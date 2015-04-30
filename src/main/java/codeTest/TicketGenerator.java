package codeTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public enum TicketGenerator {
	
	INSTANCE;
	Map<TicketType, TicketPriceCalculator> map = new HashMap<TicketType, TicketPriceCalculator>();
	
	private TicketGenerator() {
		map.put(TicketType.SINGLE, new StopsBasedTicketPriceCalculator());
		map.put(TicketType.RETURN, new ReturnTicketPriceCalculator());
	}
	
	public Ticket generateTicket(Station source, Station destination, TicketType ticketType) {
		if(source == null || destination == null ) {
			throw new IllegalArgumentException("Source and destination can not be null");
		}
		int srcIndex = StationDB.INSTANCE.getIndexOf(source);
		int destIndex = StationDB.INSTANCE.getIndexOf(destination);
		int stops = Math.abs(srcIndex - destIndex);	
		int price = map.get(ticketType).getPrice(stops);
		return new Ticket(new Date(), source, destination, stops, price, ticketType);
	}
}
