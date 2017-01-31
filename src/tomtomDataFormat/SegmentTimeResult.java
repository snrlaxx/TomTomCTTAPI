
package tomtomDataFormat;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SegmentTimeResult {

    @SerializedName("timeSet")
    @Expose
    private Integer timeSet;
    @SerializedName("dateRange")
    @Expose
    private Integer dateRange;
    @SerializedName("medianSpeed")
    @Expose
    private Double medianSpeed;
    @SerializedName("sampleSize")
    @Expose
    private Integer sampleSize;
    @SerializedName("averageTravelTime")
    @Expose
    private Double averageTravelTime;
    @SerializedName("medianTravelTime")
    @Expose
    private Double medianTravelTime;
    @SerializedName("travelTimeRatio")
    @Expose
    private Double travelTimeRatio;
    @SerializedName("speedPercentiles")
    @Expose
    private List<Integer> speedPercentiles = null;
    @SerializedName("harmonicAverageSpeed")
    @Expose
    private Double harmonicAverageSpeed;
    @SerializedName("travelTimeStandardDeviation")
    @Expose
    private Double travelTimeStandardDeviation;

    public Integer getTimeSet() {
        return timeSet;
    }

    public void setTimeSet(Integer timeSet) {
        this.timeSet = timeSet;
    }

    public Integer getDateRange() {
        return dateRange;
    }

    public void setDateRange(Integer dateRange) {
        this.dateRange = dateRange;
    }

    public Double getMedianSpeed() {
        return medianSpeed;
    }

    public void setMedianSpeed(Double medianSpeed) {
        this.medianSpeed = medianSpeed;
    }

    public Integer getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(Integer sampleSize) {
        this.sampleSize = sampleSize;
    }

    public Double getAverageTravelTime() {
        return averageTravelTime;
    }

    public void setAverageTravelTime(Double averageTravelTime) {
        this.averageTravelTime = averageTravelTime;
    }

    public Double getMedianTravelTime() {
        return medianTravelTime;
    }

    public void setMedianTravelTime(Double medianTravelTime) {
        this.medianTravelTime = medianTravelTime;
    }

    public Double getTravelTimeRatio() {
        return travelTimeRatio;
    }

    public void setTravelTimeRatio(Double travelTimeRatio) {
        this.travelTimeRatio = travelTimeRatio;
    }

    public List<Integer> getSpeedPercentiles() {
        return speedPercentiles;
    }

    public void setSpeedPercentiles(List<Integer> speedPercentiles) {
        this.speedPercentiles = speedPercentiles;
    }

    public Double getHarmonicAverageSpeed() {
        return harmonicAverageSpeed;
    }

    public void setHarmonicAverageSpeed(Double harmonicAverageSpeed) {
        this.harmonicAverageSpeed = harmonicAverageSpeed;
    }

    public Double getTravelTimeStandardDeviation() {
        return travelTimeStandardDeviation;
    }

    public void setTravelTimeStandardDeviation(Double travelTimeStandardDeviation) {
        this.travelTimeStandardDeviation = travelTimeStandardDeviation;
    }

}
