package TomTomAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class Request {

	public Address from, to;
	public String requestName;
	public String[] days;
	public String[] range;
	public String[] intervals;
	public int jobID;
	public double dist;

	public Request(Address from, Address to, String requestName) {
		this.from = from;
		this.to = to;
		this.requestName = requestName;

		this.days=Main.days;
		this.range=Main.range;
		this.intervals=Main.intervals;
	}

	public void setJobID(int id){
		this.jobID=id;
	}

	public Address getFrom() {
		return from;
	}
	public Address getTo() {
		return to;
	}
	public String getRequestName() {
		return requestName;
	}

	public int getJobID(){
		return jobID;
	}

	public double getDistance() throws IOException {

		int length = 0;

		String rountingURL="https://api.tomtom.com/routing/1/calculateRoute/<locations>/json?key=44gqwqjxvwuy5n4w7jyzasrd";
		String locations=Double.toString(from.getLat())+","+Double.toString(from.getLon())+":"+Double.toString(to.getLat())+","+Double.toString(to.getLon());

		rountingURL=rountingURL.replaceAll("<locations>",locations);

		URL obj = new URL(rountingURL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		int responseCode = con.getResponseCode();
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		JsonParser parser = new JsonParser();
		JsonElement jsonTree = parser.parse(response.toString());

		if(jsonTree.isJsonObject()){
			JsonObject jsonObject = jsonTree.getAsJsonObject();
			JsonElement routes = jsonObject.get("routes");
			if(routes.isJsonArray()){
				JsonArray jsonArray=routes.getAsJsonArray();
				JsonElement routeZero=jsonArray.get(0);
				if (routeZero.isJsonObject()) {
					JsonObject jsonObject2=routeZero.getAsJsonObject();
					JsonElement summary=jsonObject2.get("summary");
					if (summary.isJsonObject()) {
						JsonObject jsonObject3=summary.getAsJsonObject();
						JsonPrimitive lengthPrim=jsonObject3.getAsJsonPrimitive("lengthInMeters");
						length=lengthPrim.getAsInt();
					}}}}
		return length;
	}
}
