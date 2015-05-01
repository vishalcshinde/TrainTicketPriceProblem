package codeTest;

public enum TicketType {
	
	SINGLE(new StopsBasedTicketPriceCalculator()), 
	RETURN(new ReturnTicketPriceCalculator());
	
	private TicketPriceCalculator ticketPriceCalculator;
	
	private TicketType(TicketPriceCalculator ticketPriceCalculator) {
		this.ticketPriceCalculator = ticketPriceCalculator;
	}
	
	public int getTicketPrice(int stops) {
		return this.ticketPriceCalculator.getPrice(stops);
	}
}
