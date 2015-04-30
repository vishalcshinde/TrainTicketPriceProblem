package codeTest;


public class StopsBasedTicketPriceCalculator implements TicketPriceCalculator {
	
	public static final int BASE_PRICE = 10;
	public static final int MINIMUM_STOPS = 5;
	public static final int PRICE_INRCREEMENT = 5;
	public static final int FLAT_PRICE = 20;
	public static final int MAXIMUM_STOPS = StationDB.INSTANCE.getTotalStops() - 1;
	
	public StopsBasedTicketPriceCalculator() {
		
	}
	

	public int getPrice(int stops) {
		if(stops == MAXIMUM_STOPS) {
			return FLAT_PRICE;
		}
		return calculatePrice(stops, BASE_PRICE);
	}
	
	protected int calculatePrice(int numberOfstops, int price) {
		double factor = Math.ceil(numberOfstops / 5.0);
		
		return (int) (10 + 5 * (factor - 1));
		/*if (numberOfstops <= MINIMUM_STOPS) {
			return price;
		}
		return calculatePrice(numberOfstops - MINIMUM_STOPS, price + PRICE_INRCREEMENT);*/
	}
	
	

}
