package TomTomAPI;

public class AdressGroup {
	
	public Address[] locations;
	public String groupName;

	public AdressGroup(String name, Address[] locations){
		this.groupName=name;
		this.locations=locations;
	}
	
	public Address[] getLocations() {
		return locations;
	}
	
}
