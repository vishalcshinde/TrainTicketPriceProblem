package codeTest;

public class ReturnTicketPriceCalculator extends
		StopsBasedTicketPriceCalculator {
	@Override
	protected int calculatePrice(int numberOfstops, int price) {
		return 2 * super.calculatePrice(numberOfstops, price);
	}
}
