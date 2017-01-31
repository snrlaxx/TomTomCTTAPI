
package jsonschema2pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Route {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("start")
    @Expose
    private Start start;
    @SerializedName("end")
    @Expose
    private End end;
    @SerializedName("fullTraversal")
    @Expose
    private boolean fullTraversal;
    @SerializedName("zoneId")
    @Expose
    private String zoneId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Route() {
    }

    /**
     * 
     * @param start
     * @param name
     * @param fullTraversal
     * @param end
     * @param zoneId
     */
    public Route(String name, Start start, End end, boolean fullTraversal, String zoneId) {
        super();
        this.name = name;
        this.start = start;
        this.end = end;
        this.fullTraversal = fullTraversal;
        this.zoneId = zoneId;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Route withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The start
     */
    public Start getStart() {
        return start;
    }

    /**
     * 
     * @param start
     *     The start
     */
    public void setStart(Start start) {
        this.start = start;
    }

    public Route withStart(Start start) {
        this.start = start;
        return this;
    }

    /**
     * 
     * @return
     *     The end
     */
    public End getEnd() {
        return end;
    }

    /**
     * 
     * @param end
     *     The end
     */
    public void setEnd(End end) {
        this.end = end;
    }

    public Route withEnd(End end) {
        this.end = end;
        return this;
    }

    /**
     * 
     * @return
     *     The fullTraversal
     */
    public boolean isFullTraversal() {
        return fullTraversal;
    }

    /**
     * 
     * @param fullTraversal
     *     The fullTraversal
     */
    public void setFullTraversal(boolean fullTraversal) {
        this.fullTraversal = fullTraversal;
    }

    public Route withFullTraversal(boolean fullTraversal) {
        this.fullTraversal = fullTraversal;
        return this;
    }

    /**
     * 
     * @return
     *     The zoneId
     */
    public String getZoneId() {
        return zoneId;
    }

    /**
     * 
     * @param zoneId
     *     The zoneId
     */
    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public Route withZoneId(String zoneId) {
        this.zoneId = zoneId;
        return this;
    }

}
