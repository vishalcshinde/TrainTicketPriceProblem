package codeTest;

import java.util.Date;

public class Ticket {
	private Date purchaseDateTime;
	private Station sourceStation;
	private Station desStation;
	private int stops;
	private int price;
	TicketType ticketType;
	
	public Ticket() {
	}

	public Ticket(Date purchaseDateTime, Station sourceStation,
			Station desStation, int stops, int price, TicketType ticketType) {
		this.purchaseDateTime = purchaseDateTime;
		this.sourceStation = sourceStation;
		this.desStation = desStation;
		this.stops = stops;
		this.price = price;
		this.ticketType = ticketType;
	}

	public Date getPurchaseDateTime() {
		return purchaseDateTime;
	}

	public void setPurchaseDateTime(Date purchaseDateTime) {
		this.purchaseDateTime = purchaseDateTime;
	}

	public Station getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(Station sourceStation) {
		this.sourceStation = sourceStation;
	}

	public Station getDestinationStation() {
		return desStation;
	}

	public void setDesStation(Station desStation) {
		this.desStation = desStation;
	}

	public int getStops() {
		return stops;
	}

	public void setStops(int stops) {
		this.stops = stops;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((desStation == null) ? 0 : desStation.hashCode());
		result = prime * result + price;
		result = prime
				* result
				+ ((purchaseDateTime == null) ? 0 : purchaseDateTime.hashCode());
		result = prime * result
				+ ((sourceStation == null) ? 0 : sourceStation.hashCode());
		result = prime * result + stops;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (desStation == null) {
			if (other.desStation != null)
				return false;
		} else if (!desStation.equals(other.desStation))
			return false;
		if (price != other.price)
			return false;
		if (purchaseDateTime == null) {
			if (other.purchaseDateTime != null)
				return false;
		} else if (!purchaseDateTime.equals(other.purchaseDateTime))
			return false;
		if (sourceStation == null) {
			if (other.sourceStation != null)
				return false;
		} else if (!sourceStation.equals(other.sourceStation))
			return false;
		if (stops != other.stops)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		String str = "Date : " + purchaseDateTime;
		str = str + "\nSource Station : " + (sourceStation != null ? sourceStation.getName() : "<Not Provided>");
		str = str + "\nDestination : " + (desStation != null ? desStation.getName() : "<Not Provided>");
		str = str + "\nStops : " + stops;
		str = str + "\nPrice : " + price;
		return str;
	}
}