package TomTomAPI;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.opencsv.CSVWriter;

import jsonschema2pojo.Response;
import jsonschema2pojo.Status;
import jsonschema2pojo.TomTomRequest;
import tomtomDataFormat.TomTomResponse;

public class CttAPI {

	public static int writeRequest(TomTomRequest request) throws IOException{

		String requestURL="https://api.tomtom.com/traffic/trafficstats/ctt/1?key=XXXX";

 		double dist=getRouteLength(request);
		int jobID = -1;

		if (dist!=-1 && dist<Main.maxDistAllowed) {
			try {
				URL url = new URL(requestURL);  
				HttpURLConnection con = (HttpURLConnection) url.openConnection();  

				con.setRequestMethod("POST");  
				con.setRequestProperty("Content-Type","application/json");  

				Gson gson = new Gson();
				String jsonData = gson.toJson(request);

				con.setDoOutput(true);  
				DataOutputStream wr = new DataOutputStream(con.getOutputStream());  
				wr.writeBytes(jsonData);  
				wr.flush();  
				wr.close();  

				System.out.println("Sending 'POST' request of route"+request.getJobName());  

				BufferedReader in = new BufferedReader(  
						new InputStreamReader(con.getInputStream()));  
				String output;  
				StringBuffer response = new StringBuffer();  

				while ((output = in.readLine()) != null) {  
					response.append(output);  
				}  
				in.close();

				Response responseData = gson.fromJson(response.toString(),Response.class);
				jobID=Integer.parseInt(responseData.getJobId());
				System.out.println("Route "+request.getJobName()+" has jobID="+jobID+"\n");
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			if (dist>=Main.maxDistAllowed){
				System.out.println("Route "+ request.getJobName() + " is " + dist + " m long.\nThe maximum length supported by the API is 200 Km." );
			}
			if (dist==-1){
				System.out.println("Route legnth could not be obtained. Route skipped.");
			}
		}
		
		if (jobID==-1) {
			
		}
		return jobID;  
	}

	public static Status getStatus(int jobID) throws IOException {

		String statusURL="https://api.tomtom.com/traffic/trafficstats/status/1/"+jobID+"?key=XXXXXX";

		URL status = new URL(statusURL);
		HttpURLConnection statusCon = (HttpURLConnection)status.openConnection();

		System.out.println("Getting request status of route " + jobID +"...");  

		BufferedReader in = new BufferedReader( new InputStreamReader(statusCon.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		Gson gson = new Gson();
		Status requestStatus = gson.fromJson(response.toString(),Status.class);
		return requestStatus;
	}

	public static void downloadJob(Status status) throws IOException {

		String url=status.getUrls().get(0);

		URL data = new URL(url);
		HttpURLConnection dataCon = (HttpURLConnection)data.openConnection();

		System.out.println("\nDownlaoding request data of route "+status.getJobId()+"...");  

		BufferedReader in = null;
		String response = "";


		if (dataCon.getHeaderField("Content-Encoding")!=null && dataCon.getHeaderField("Content-Encoding").equals("gzip")){
			in = new BufferedReader(new InputStreamReader(new GZIPInputStream(dataCon.getInputStream())));            
		} else {
			in = new BufferedReader(new InputStreamReader(dataCon.getInputStream()));            
		}     
		String inputLine;
		while ((inputLine = in.readLine()) != null){
			response+=inputLine+"\n";
		}
		in.close();

		Gson gson = new Gson();
		TomTomResponse jsonResponse = gson.fromJson(response.toString(),TomTomResponse.class);
		System.out.println("Route data downloded!");  

		toCSV(jsonResponse);
	}

	private static void toCSV(TomTomResponse jsonResponse) throws IOException {

		String[] jobName = jsonResponse.getJobName().split("~");
		String days=Arrays.toString(Main.days).replaceAll(",", "-").replaceAll(" ", "").replaceAll("\\[", "").replaceAll("\\]", "");

		int numTimeSets=jsonResponse.getTimeSets().size();	
		String[] time = new String[numTimeSets];
		Double[] avTT= new Double[numTimeSets];
		Double[] medTT= new Double[numTimeSets];
		Double[][] ttPercentiles= new Double[numTimeSets][19];

		for (int i = 0; i < numTimeSets; i++) {
			time[i]=jsonResponse.getTimeSets().get(i).getDayToTimeRanges().get(0).getTimeRanges().get(0);
		}

		String[] dur=new String[time.length];
		Date[] startTime = new Date[time.length];
		SimpleDateFormat inputDateFormat = new SimpleDateFormat("HH:mm");		
		SimpleDateFormat outputDateFormat= new SimpleDateFormat("HH:mm:ss");
		for (int i = 0; i < time.length; i++) {
			String[] string = time[i].split("-");

			//Clean special chars
			for (int j = 0; j < string.length; j++) {
				String string2 = string[j];
				string2=string2.replaceAll("\\[", "");
				string2=string2.replaceAll("\\]", "");
				string[j]=string2;
			}
			Date endTime = null;
			try {
				startTime[i] = inputDateFormat.parse(string[0]);
				endTime = inputDateFormat.parse(string[1]);
				String duration=getTimeDiff(startTime[i],endTime);
				dur[i]=duration;
			} catch (ParseException e) {
				e.printStackTrace();
			}

			avTT[i]=jsonResponse.getRoutes().get(0).getSummaries().get(i).getAverageTravelTime();
			medTT[i]=jsonResponse.getRoutes().get(0).getSummaries().get(i).getMedianTravelTime();

			for (int j = 0; j < 19; j++) {
				ttPercentiles[i][j]=(jsonResponse.getRoutes().get(0).getSummaries().get(i).getTravelTimePercentiles().get(j).doubleValue());
			}

		}
		FileWriter resultsFile= new FileWriter(Main.resultFileName+".csv",true);
		CSVWriter writer = new CSVWriter(resultsFile, ',', CSVWriter.NO_QUOTE_CHARACTER);

		for (int i = 0; i < numTimeSets; i++) {
			String entry = jobName[0]+"#"+jobName[1]+"#"+days+"#"+outputDateFormat.format(startTime[i])+"#"+dur[i]+"#"+
					seconds2Dur(avTT[i])+"#"+seconds2Dur(medTT[i])+"#"+seconds2Dur(ttPercentiles[i]);
			String[] entries=entry.split("#");

			writer.writeNext(entries);
		}
		writer.close();
	}


	public static double getRouteLength(TomTomRequest request) throws IOException {

		int length=-1;

		String rountingURL="https://api.tomtom.com/routing/1/calculateRoute/<locations>/json?key=XXXX";
		String locations=Double.toString(request.getRoutes().get(0).getStart().getLatitude())+","
				+Double.toString(request.getRoutes().get(0).getStart().getLongitude())+":"
				+Double.toString(request.getRoutes().get(0).getEnd().getLatitude())+","
				+Double.toString(request.getRoutes().get(0).getEnd().getLongitude());

		rountingURL=rountingURL.replaceAll("<locations>",locations);

		URL obj = new URL(rountingURL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

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
		System.out.println("Route "+request.getJobName()+" length is " + length + " meters.");

		return length;
	}

	public static String getTimeDiff(Date dateOne, Date dateTwo) {
		String diff = "";
		long timeDiff = Math.abs(dateOne.getTime() - dateTwo.getTime());
		diff = String.format("%02d:%02d:00", TimeUnit.MILLISECONDS.toHours(timeDiff),
				TimeUnit.MILLISECONDS.toMinutes(timeDiff) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeDiff)));
		return diff;
	}
	private static String seconds2Dur(Double totalSeconds) {
		int hours = (int) (totalSeconds / 3600);
		int minutes = (int) ((totalSeconds % 3600) / 60);
		int seconds = (int) (totalSeconds % 60);
		String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);		
		return timeString;
	}
	private static String seconds2Dur(Double[] percentiles) {
		String percentilesDur=null;
		for (int i = 0; i < percentiles.length; i++) {
			double totalSeconds=percentiles[i];
			int hours = (int) (totalSeconds / 3600);
			int minutes = (int) ((totalSeconds % 3600) / 60);
			int seconds = (int) (totalSeconds % 60);
			String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
			if (i==0) {
				percentilesDur=timeString;
			} else {
				percentilesDur=percentilesDur+"#"+timeString;
			}
		}
		return percentilesDur;
	}
}
