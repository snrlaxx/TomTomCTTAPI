package TomTomAPI;

public class Address {

	private String name;
	private double lat;
	private double lon;
	
	public Address(String name, double lat, double lon) {
		this.name = name;
		this.lat = lat;
		this.lon = lon;
	}
	
	public Address(String name){
		this.name=name;
		this.lat=0;
		this.lon=0;
	}

	public String getName() {
		return name;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}
	
}
