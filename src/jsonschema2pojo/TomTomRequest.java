
package jsonschema2pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TomTomRequest {

    @SerializedName("jobName")
    @Expose
    private String jobName;
    @SerializedName("distanceUnit")
    @Expose
    private String distanceUnit;
    @SerializedName("routes")
    @Expose
    private List<Route> routes = null;
    @SerializedName("dateRanges")
    @Expose
    private List<DateRange> dateRanges = null;
    @SerializedName("timeSets")
    @Expose
    private List<TimeSet> timeSets = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TomTomRequest() {
    }

    /** 
     * 
     * @param routes
     * @param dateRanges
     * @param timeSets
     * @param distanceUnit
     * @param jobName
     */
    public TomTomRequest(String jobName, List<Route> routes, List<DateRange> dateRanges, List<TimeSet> timeSets) {
        this.jobName = jobName;
        this.distanceUnit="KILOMETERS";
        this.routes = routes;
        this.dateRanges = dateRanges;
        this.timeSets = timeSets;
    }

    /**
     * 
     * @return
     *     The jobName
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 
     * @param jobName
     *     The jobName
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public TomTomRequest withJobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    /**
     * 
     * @return
     *     The distanceUnit
     */
    public String getDistanceUnit() {
        return distanceUnit;
    }

    /**
     * 
     * @param distanceUnit
     *     The distanceUnit
     */
    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public TomTomRequest withDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
        return this;
    }

    /**
     * 
     * @return
     *     The routes
     */
    public List<Route> getRoutes() {
        return routes;
    }

    /**
     * 
     * @param routes
     *     The routes
     */
    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public TomTomRequest withRoutes(List<Route> routes) {
        this.routes = routes;
        return this;
    }

    /**
     * 
     * @return
     *     The dateRanges
     */
    public List<DateRange> getDateRanges() {
        return dateRanges;
    }

    /**
     * 
     * @param dateRanges
     *     The dateRanges
     */
    public void setDateRanges(List<DateRange> dateRanges) {
        this.dateRanges = dateRanges;
    }

    public TomTomRequest withDateRanges(List<DateRange> dateRanges) {
        this.dateRanges = dateRanges;
        return this;
    }

    /**
     * 
     * @return
     *     The timeSets
     */
    public List<TimeSet> getTimeSets() {
        return timeSets;
    }

    /**
     * 
     * @param timeSets
     *     The timeSets
     */
    public void setTimeSets(List<TimeSet> timeSets) {
        this.timeSets = timeSets;
    }

    public TomTomRequest withTimeSets(List<TimeSet> timeSets) {
        this.timeSets = timeSets;
        return this;
    }

}
