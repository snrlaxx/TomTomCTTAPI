package TomTomAPI;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import jsonschema2pojo.Status;
import jsonschema2pojo.TomTomRequest;


public class Main {
//

	public static int poolSize;// number of simultaneous jobs written to TomTom API
	public static final double maxDistAllowed=200000; // max. route distance allowed by TomTom API
	public static final int sec=10*60; //number of seconds to wait before posting a job batch
	public static String[] days;
	public static String[] range;
	public static String[] intervals;
	public static String apiKey;
	public static String resultFileName;


	static Boolean complete=false;
	static int lastJob=-1;

	public static void main(String[] args) throws IOException, InterruptedException {

		APIParam properties = new APIParam();
		poolSize=properties.getpoolSize();
		days=properties.getDays();
		range=properties.getRange();
		intervals=properties.getIntervals();
		resultFileName=properties.getResultFileName();

		apiKey=properties.getapiKey();

		File selectedFile = null;

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		fileChooser.setFileFilter(new FileNameExtensionFilter(".csv", "csv"));
		int result = fileChooser.showOpenDialog(fileChooser);
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
			System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		}

		ArrayList<TomTomRequest> requestList=readFile(selectedFile);
		int [] poolIDs=postFirstBatch(requestList);
		downloadRoutine(poolIDs,requestList);
	}

	private static void downloadRoutine(int[] poolIDs, ArrayList<TomTomRequest> requestList) throws InterruptedException, IOException {

		int numberofJobs=lastJob;
		boolean comp=complete;

		int n=requestList.size();
		if (poolSize>n) {
			poolSize=n;
		}

		while (comp==false) {
			System.out.println("Waiting "+sec+" seconds before checking status and downloading job...");
			TimeUnit.SECONDS.sleep(sec);
			for (int i = 0; i < poolSize; i++) {
				if (poolIDs[i]==-1) {
					//do nothing
				}else {
					Status status=CttAPI.getStatus(poolIDs[i]);
					if (status.getUrls()!=null){
						System.out.println("Route "+status.getJobId()+" is ready to download.");
						CttAPI.downloadJob(status);
						if (numberofJobs+1<=requestList.size()-1) {
							TomTomRequest request=requestList.get(numberofJobs+1);
							numberofJobs++;
							lastJob++;
							int jobID=CttAPI.writeRequest(request);
							poolIDs[i]=jobID;
						}
					}
				}
			}

			if (numberofJobs>=requestList.size()-1) {
				complete=true;
				System.out.println("Travel time data has been downloaded. Please check file \""+ resultFileName+".csv\" for the results.");
				System.exit(0);
			}
		}

	}

	private static int[] postFirstBatch(ArrayList<TomTomRequest> requestList) throws IOException {

		int[] poolIDs = new int[poolSize];
		int n=requestList.size();

		if (poolSize>n) {
			poolSize=n;
		}		
		System.out.println("\nSending first batch of "+poolSize+" POST requests to TomTom API:\n");

		for (int i = 0; i < poolSize; i++) {
			TomTomRequest request=requestList.get(i);
			int jobID=CttAPI.writeRequest(request);
			poolIDs[i]=jobID;
			lastJob++;
		}
		System.out.println("First batch of "+poolSize+" POST requests sent. Starting downloadRoutine now...\n");

		return poolIDs;
	}

	private static ArrayList<TomTomRequest> readFile(File file) throws IOException, InterruptedException {
		System.out.println("Opening file "+file+" ...");
		QuintiqRoutes quintiq = new QuintiqRoutes();
		ArrayList<TomTomRequest> requestList=quintiq.parseCSV(file); 
		return requestList; 
	}


}


