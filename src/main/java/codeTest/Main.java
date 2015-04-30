package codeTest;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		int i = 0;
		for(Station station : StationDB.INSTANCE.getStations()) {
			System.out.format("%d %s => %s \n", ++i, station.getCode(), station.getName());
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Source station \n");
		int source = sc.nextInt();
		validate(source);
		System.out.println("Please enter Destination station \n");
		int dest = sc.nextInt();
		validate(dest);
		sc.close();
		Station sourceStn = StationDB.INSTANCE.getStations().get(source - 1);
		Station desStation = StationDB.INSTANCE.getStations().get(dest - 1);
		Ticket ticket = TicketGenerator.INSTANCE.generateTicket(sourceStn, desStation, TicketType.SINGLE);
		System.out.println(ticket);
	}

	private static void validate(int source) {
		if(source < 0 || source > StationDB.INSTANCE.getStations().size()) {
			throw new IllegalArgumentException("number not in range");
		}
	}
}
