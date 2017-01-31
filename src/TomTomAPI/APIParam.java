package TomTomAPI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class APIParam {

	int poolSize;
	String[] days;
	String[] range;
	String[] intervals;
	String apiKey;
	String resultFileName;

	InputStream inputStream;


	public APIParam() throws IOException {
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			poolSize = Integer.parseInt(prop.getProperty("poolSize"));
			days=prop.get("days").toString().split(",");
			range=prop.get("range").toString().split(",");
			intervals=prop.get("intervals").toString().split(",");
			apiKey=prop.getProperty("apiKey");
			resultFileName=prop.getProperty("resultsFileName");

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
	}

	public int getpoolSize(){
		return poolSize;
	}
	public String[] getDays(){
		return days;
	}
	public String[] getRange() {
		return range;
	}

	public String[] getIntervals() {
		return intervals;
	}

	public String getapiKey() {
		return apiKey;
	}

	public String getResultFileName() {
		return resultFileName;
	}

}
