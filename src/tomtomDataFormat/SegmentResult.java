
package tomtomDataFormat;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SegmentResult {

    @SerializedName("segmentId")
    @Expose
    private Double segmentId;
    @SerializedName("speedLimit")
    @Expose
    private Integer speedLimit;
    @SerializedName("frc")
    @Expose
    private Integer frc;
    @SerializedName("streetName")
    @Expose
    private String streetName;
    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("shape")
    @Expose
    private List<Shape> shape = null;
    @SerializedName("segmentTimeResults")
    @Expose
    private List<SegmentTimeResult> segmentTimeResults = null;

    public Double getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(Double segmentId) {
        this.segmentId = segmentId;
    }

    public Integer getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(Integer speedLimit) {
        this.speedLimit = speedLimit;
    }

    public Integer getFrc() {
        return frc;
    }

    public void setFrc(Integer frc) {
        this.frc = frc;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public List<Shape> getShape() {
        return shape;
    }

    public void setShape(List<Shape> shape) {
        this.shape = shape;
    }

    public List<SegmentTimeResult> getSegmentTimeResults() {
        return segmentTimeResults;
    }

    public void setSegmentTimeResults(List<SegmentTimeResult> segmentTimeResults) {
        this.segmentTimeResults = segmentTimeResults;
    }

}
