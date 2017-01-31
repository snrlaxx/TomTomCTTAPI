package TomTomAPI;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import com.opencsv.CSVReader;

import jsonschema2pojo.DateRange;
import jsonschema2pojo.End;
import jsonschema2pojo.Route;
import jsonschema2pojo.Start;
import jsonschema2pojo.TimeGroup;
import jsonschema2pojo.TimeSet;
import jsonschema2pojo.TomTomRequest;

public class QuintiqRoutes extends JFrame{

	private static final long serialVersionUID = 1L;

	public ArrayList<TomTomRequest> requestList = new ArrayList<TomTomRequest>();
	public ArrayList<Address> locations = new ArrayList<Address>();
	public ArrayList<AdressGroup> adressGroups = new ArrayList<AdressGroup>();
	public ArrayList<String[]> combinations = new ArrayList<String[]>();

	List<DateRange> dateRanges = new ArrayList<DateRange>();
	List<String> days = Arrays.asList(Main.days);
	List<String> intervals = Arrays.asList(Main.intervals);
	List<TimeGroup> timeGroups = new ArrayList<TimeGroup>();
	List<TimeSet> timeSets = new ArrayList<TimeSet>();


	public QuintiqRoutes(){

		DateRange dateRange= new DateRange(Main.range[0], Main.range[1], Main.range[2]);
		dateRanges.add(dateRange);
		for (int i = 0; i < intervals.size(); i++) {
			timeGroups.add(new TimeGroup(days,Arrays.asList(intervals.get(i))));
			timeSets.add(new TimeSet(getTimeGroupName(Main.days,i), Arrays.asList(timeGroups.get(i))));
		}
	}

	private String getTimeGroupName(String[] days, int i) {
		StringBuilder builder = new StringBuilder();
		for(String s : days) {
			builder.append(s);
			builder.append("-");
		}
		builder.deleteCharAt(builder.length()-1);
		builder.append("- "+i+" Interval");
		return builder.toString();	
	}

	public  ArrayList<TomTomRequest>  parseCSV(File file) throws IOException{
		System.out.println("Parsing file "+ file +" ...");

		CSVReader parser = new CSVReader(new FileReader(file));
		String[] nextLine;
		int emptyLines=0;

		while ((nextLine = parser.readNext()) != null) {

			if (nextLine.length==1) {
				emptyLines++;}

			if (emptyLines==0 && nextLine.length==3) {
				Address loc= new Address(nextLine[0].toString(),Double.parseDouble(nextLine[1]), Double.parseDouble(nextLine[2]));
				locations.add(loc);

			}else if (emptyLines==1 && nextLine.length>1){
				Address[] locs=new Address[nextLine.length-1];

				for (int i = 1; i < nextLine.length; i++) {

					for (int j = 0; j < locations.size(); j++) {
						if (locations.get(j).getName().equals(nextLine[i])) {
							Address loc=locations.get(j);
							locs[i-1]=loc;}}}
				AdressGroup gro= new AdressGroup(nextLine[0],locs);
				adressGroups.add(gro);

			}else if (emptyLines==2 && nextLine.length>1) {
				combinations.add(nextLine);
			}}	
		parser.close();
		return requestList=createRequestList(locations, adressGroups, combinations);	
	}

	public ArrayList<TomTomRequest> createRequestList(ArrayList<Address> locations, ArrayList<AdressGroup> adressGroups, ArrayList<String[]> combinations) {

		for (int n_comb = 0; n_comb < combinations.size(); n_comb++) {

			String from_groupID=combinations.get(n_comb)[0];
			String to_groupID=combinations.get(n_comb)[1];

			int adressGroupIndexfrom=findGroupIndex(from_groupID,adressGroups);
			int adressGroupIndexto=findGroupIndex(to_groupID,adressGroups);

			Address[] fromLocations= adressGroups.get(adressGroupIndexfrom).locations;
			Address[] toLocations=adressGroups.get(adressGroupIndexto).locations;

			Start[] startAddresses= new Start[fromLocations.length];
			for (int z = 0; z < fromLocations.length; z++) {
				Start start= new Start(fromLocations[z].getLat(), fromLocations[z].getLon());
				startAddresses[z]=start;
			}

			End[] endAddresses= new End[toLocations.length];
			for (int j = 0; j < toLocations.length; j++) {
				End end= new End(toLocations[j].getLat(), toLocations[j].getLon());
				endAddresses[j]=end;
			}


			for (int i = 0; i < fromLocations.length; i++) {

				String fromName=fromLocations[i].getName();	

				for (int k = 0; k < toLocations.length; k++) {
					String toName=toLocations[k].getName();	

					if (!toName.equals(fromName)) {

						String jobName= fromName + "~" + toName;

						Route route=new Route(jobName, startAddresses[i], endAddresses[k], false, "Europe/Amsterdam");
						List<Route> routes = (List<Route>) Arrays.asList(route);

						TomTomRequest requestTomTom= new TomTomRequest(jobName, routes, dateRanges, timeSets);
						requestList.add(requestTomTom);
					}
				}
			}
		}
		return requestList;}

	private int findGroupIndex(String groupID, ArrayList<AdressGroup> adressGroups) {
		int index=-1;
		for (int i = 0; i < adressGroups.size(); i++) {
			if (adressGroups.get(i).groupName.equals(groupID)) {
				index=i;}}
		return index;}
	public ArrayList<Address> getLocations() {
		return locations;}
	public ArrayList<AdressGroup> getGroups() {
		return adressGroups;}
	public ArrayList<String[]> getCombinations() {
		return combinations;}
	public ArrayList<TomTomRequest> getRequestList() {
		return requestList;}
}
