package codeTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum StationDB {
	INSTANCE;
	private List<Station> stations = new ArrayList<Station>();

	private StationDB() {
		stations.add(new Station("cb", "Chennai Beach"));
		stations.add(new Station("cf", "Chennai Fort"));
		stations.add(new Station("cp", "Chennai Park"));
		stations.add(new Station("ce", "Chennai Egmore"));
		stations.add(new Station("ch", "Chetpet"));
		stations.add(new Station("nu", "Nungambakkam"));
		stations.add(new Station("nu", "Kodambakkam"));
		stations.add(new Station("ma", "Mambalam"));
		stations.add(new Station("sa", "Saidapet"));
		stations.add(new Station("gu", "Guindy"));
		stations.add(new Station("st", "St. Thomas Mount"));
		stations.add(new Station("pa", "Pazhavanthangal"));
		stations.add(new Station("me", "Meenambakkam"));
		stations.add(new Station("tr", "Trisulam"));
		stations.add(new Station("pa", "Pallavaram"));
		stations.add(new Station("cr", "Chromepet"));
		stations.add(new Station("ts", "Tambaram Sanatorium"));
		stations.add(new Station("tb", "Tambaram"));
		stations = Collections.unmodifiableList(stations);
	}

	public int getIndexOf(Station station) {
		if(station == null) {
			throw new IllegalArgumentException("Station can not be null");
		}
		int index = stations.indexOf(station);
		if(index == -1) {
			throw new StationNotFoundException("Station does not exist in DB");
		}
		return index;
	}
	
	public List<Station> getStations() {
		return stations;
	}
	
	

	public int getTotalStops() {
		return stations.size();
	}
}
