
package tomtomDataFormat;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TomTomResponse {

    @SerializedName("jobName")
    @Expose
    private String jobName;
    @SerializedName("creationTime")
    @Expose
    private String creationTime;
    @SerializedName("userPreference")
    @Expose
    private UserPreference userPreference;
    @SerializedName("dateRanges")
    @Expose
    private List<DateRange> dateRanges = null;
    @SerializedName("timeSets")
    @Expose
    private List<TimeSet> timeSets = null;
    @SerializedName("routes")
    @Expose
    private List<Route> routes = null;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public UserPreference getUserPreference() {
        return userPreference;
    }

    public void setUserPreference(UserPreference userPreference) {
        this.userPreference = userPreference;
    }

    public List<DateRange> getDateRanges() {
        return dateRanges;
    }

    public void setDateRanges(List<DateRange> dateRanges) {
        this.dateRanges = dateRanges;
    }

    public List<TimeSet> getTimeSets() {
        return timeSets;
    }

    public void setTimeSets(List<TimeSet> timeSets) {
        this.timeSets = timeSets;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

}
