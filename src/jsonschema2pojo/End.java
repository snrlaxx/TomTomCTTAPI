
package jsonschema2pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class End   {

	@SerializedName("latitude")
	@Expose
	private double latitude;
	@SerializedName("longitude")
	@Expose
	private double longitude;

	/**
	 * No args constructor for use in serialization
	 * 
	 */

	/**
	 * 
	 * @param longitude
	 * @param latitude
	 */
	public End( double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * 
	 * @return
	 *     The latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * 
	 * @param latitude
	 *     The latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public End withLatitude(double latitude) {
		this.latitude = latitude;
		return this;
	}

	/**
	 * 
	 * @return
	 *     The longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * 
	 * @param longitude
	 *     The longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public End withLongitude(double longitude) {
		this.longitude = longitude;
		return this;
	}

}
