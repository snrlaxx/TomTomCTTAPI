
package tomtomDataFormat;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Route {

    @SerializedName("routeName")
    @Expose
    private String routeName;
    @SerializedName("zoneId")
    @Expose
    private String zoneId;
    @SerializedName("fullTraversal")
    @Expose
    private Boolean fullTraversal;
    @SerializedName("mapsVersions")
    @Expose
    private List<String> mapsVersions = null;
    @SerializedName("segmentResults")
    @Expose
    private List<SegmentResult> segmentResults = null;
    @SerializedName("summaries")
    @Expose
    private List<Summary> summaries = null;

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public Boolean getFullTraversal() {
        return fullTraversal;
    }

    public void setFullTraversal(Boolean fullTraversal) {
        this.fullTraversal = fullTraversal;
    }

    public List<String> getMapsVersions() {
        return mapsVersions;
    }

    public void setMapsVersions(List<String> mapsVersions) {
        this.mapsVersions = mapsVersions;
    }

    public List<SegmentResult> getSegmentResults() {
        return segmentResults;
    }

    public void setSegmentResults(List<SegmentResult> segmentResults) {
        this.segmentResults = segmentResults;
    }

    public List<Summary> getSummaries() {
        return summaries;
    }

    public void setSummaries(List<Summary> summaries) {
        this.summaries = summaries;
    }

}
