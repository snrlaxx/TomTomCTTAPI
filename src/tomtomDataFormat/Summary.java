
package tomtomDataFormat;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Summary {

    @SerializedName("dateRange")
    @Expose
    private Integer dateRange;
    @SerializedName("timeSet")
    @Expose
    private Integer timeSet;
    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("coveredDistance")
    @Expose
    private Double coveredDistance;
    @SerializedName("averageSampleSize")
    @Expose
    private Double averageSampleSize;
    @SerializedName("harmonicAverageSpeed")
    @Expose
    private Double harmonicAverageSpeed;
    @SerializedName("averageTravelTime")
    @Expose
    private Double averageTravelTime;
    @SerializedName("medianTravelTime")
    @Expose
    private Double medianTravelTime;
    @SerializedName("averageTravelTimeRatio")
    @Expose
    private Double averageTravelTimeRatio;
    @SerializedName("travelTimePercentiles")
    @Expose
    private List<Double> travelTimePercentiles = null;
    @SerializedName("speedPercentiles")
    @Expose
    private List<Double> speedPercentiles = null;

    public Integer getDateRange() {
        return dateRange;
    }

    public void setDateRange(Integer dateRange) {
        this.dateRange = dateRange;
    }

    public Integer getTimeSet() {
        return timeSet;
    }

    public void setTimeSet(Integer timeSet) {
        this.timeSet = timeSet;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getCoveredDistance() {
        return coveredDistance;
    }

    public void setCoveredDistance(Double coveredDistance) {
        this.coveredDistance = coveredDistance;
    }

    public Double getAverageSampleSize() {
        return averageSampleSize;
    }

    public void setAverageSampleSize(Double averageSampleSize) {
        this.averageSampleSize = averageSampleSize;
    }

    public Double getHarmonicAverageSpeed() {
        return harmonicAverageSpeed;
    }

    public void setHarmonicAverageSpeed(Double harmonicAverageSpeed) {
        this.harmonicAverageSpeed = harmonicAverageSpeed;
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

    public Double getAverageTravelTimeRatio() {
        return averageTravelTimeRatio;
    }

    public void setAverageTravelTimeRatio(Double averageTravelTimeRatio) {
        this.averageTravelTimeRatio = averageTravelTimeRatio;
    }

    public List<Double> getTravelTimePercentiles() {
        return travelTimePercentiles;
    }

    public void setTravelTimePercentiles(List<Double> travelTimePercentiles) {
        this.travelTimePercentiles = travelTimePercentiles;
    }

    public List<Double> getSpeedPercentiles() {
        return speedPercentiles;
    }

    public void setSpeedPercentiles(List<Double> speedPercentiles) {
        this.speedPercentiles = speedPercentiles;
    }

}
