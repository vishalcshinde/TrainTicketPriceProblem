package codeTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class TicketPriceCalculatorTest {
	
	
	@Test
	public void testBasePrice() throws Exception {
		
		Station source = new Station("cb","Chennai Beach");
		Station dest = new Station("cf","Chennai Fort");
		Ticket ticket = TicketGenerator.INSTANCE.generateTicket(source, dest, TicketType.SINGLE);
		assertEquals("base price should be 10 for distance of 5 station", 10, ticket.getPrice());
		assertEquals("number of stations should be 1 ", 1, ticket.getStops());
		assertEquals("source is not correct", source, ticket.getSourceStation());
		assertEquals("dest is not correct", dest, ticket.getDestinationStation());
		
		source = new Station("cb","Chennai Beach");
		dest = new Station("ch","Chetpet");
		ticket = TicketGenerator.INSTANCE.generateTicket(source, dest, TicketType.SINGLE);
		assertEquals("base price should be 10 for distance of 5 station", 10, ticket.getPrice());
		assertEquals("number of stations should be 4 ", 4, ticket.getStops());
		assertEquals("source is not correct", source, ticket.getSourceStation());
		assertEquals("dest is not correct", dest, ticket.getDestinationStation());
		
		
		source = new Station("ch","Chetpet");
		dest = new Station("cb","Chennai Beach"); 
		ticket = TicketGenerator.INSTANCE.generateTicket(source, dest, TicketType.SINGLE);
		assertEquals("base price should be 10 for distance of 5 station", 10, ticket.getPrice());
		assertEquals("number of stations should be 4 ", 4, ticket.getStops());
		assertEquals("source is not correct", source, ticket.getSourceStation());
		assertEquals("dest is not correct", dest, ticket.getDestinationStation());
		
		source = new Station("nu", "Kodambakkam");
		dest = new Station("gu", "Guindy"); 
		ticket = TicketGenerator.INSTANCE.generateTicket(source, dest, TicketType.SINGLE);
		assertEquals("base price should be 10 for distance of 5 station", 10, ticket.getPrice());
		assertEquals("number of stations should be 3 ", 3, ticket.getStops());
		assertEquals("source is not correct", source, ticket.getSourceStation());
		assertEquals("dest is not correct", dest, ticket.getDestinationStation());
		
	}
	
	@Test
	public void testExtensionPrice() throws Exception {
		
		Station source = new Station("gu","Guindy");
		Station dest = new Station("cf","Chennai Fort");
		Ticket ticket = TicketGenerator.INSTANCE.generateTicket(source, dest, TicketType.SINGLE);
		assertEquals("ticket price not correct", 15, ticket.getPrice());
		assertEquals("number of stops not correct ", 8, ticket.getStops());
		assertEquals("source is not correct", source, ticket.getSourceStation());
		assertEquals("dest is not correct", dest, ticket.getDestinationStation());
		
		source = new Station("cf","Chennai Fort");
		dest = new Station("gu","Guindy");
		ticket = TicketGenerator.INSTANCE.generateTicket(source, dest, TicketType.SINGLE);
		assertEquals("ticket price not correct", 15, ticket.getPrice());
		assertEquals("number of stops not correct ", 8, ticket.getStops());
		assertEquals("source is not correct", source, ticket.getSourceStation());
		assertEquals("dest is not correct", dest, ticket.getDestinationStation());
	}
	
	@Test
	public void testFlatPrice() throws Exception {
		
		Station source = new Station("cb", "Chennai Beach");
		Station dest = new Station("tb", "Tambaram");
		Ticket ticket = TicketGenerator.INSTANCE.generateTicket(source, dest, TicketType.SINGLE);
		assertEquals("ticket price not correct", 20, ticket.getPrice());
		assertEquals("number of stops not correct ", 17, ticket.getStops());
		assertEquals("source is not correct", source, ticket.getSourceStation());
		assertEquals("dest is not correct", dest, ticket.getDestinationStation());
		
		source = new Station("tb", "Tambaram");
		dest = new Station("cb", "Chennai Beach"); 
		ticket = TicketGenerator.INSTANCE.generateTicket(source, dest, TicketType.SINGLE);
		assertEquals("ticket price not correct", 20, ticket.getPrice());
		assertEquals("number of stops not correct ", 17, ticket.getStops());
		assertEquals("source is not correct", source, ticket.getSourceStation());
		assertEquals("dest is not correct", dest, ticket.getDestinationStation());
	}
	
	
	@Test(expected=StationNotFoundException.class)
	public void testStationNotFoundException() throws Exception {
		StationDB.INSTANCE.getIndexOf(new Station("", ""));
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testUnsupportedOperationException() throws Exception {
		StationDB.INSTANCE.getStations().add(new Station("", ""));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalArgumentException() throws Exception {
		
		TicketGenerator.INSTANCE.generateTicket(null, null, TicketType.SINGLE);
	}
	
}
