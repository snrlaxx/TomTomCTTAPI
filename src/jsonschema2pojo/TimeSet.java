
package jsonschema2pojo;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeSet {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("timeGroups")
    @Expose
    private List<TimeGroup> timeGroups = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TimeSet() {
    }

    /**
     * 
     * @param timeGroups
     * @param name
     */
    public TimeSet(String name, List<TimeGroup> timeGroups) {
        super();
        this.name = name;
        this.timeGroups = timeGroups;
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

    public TimeSet withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The timeGroups
     */
    public List<TimeGroup> getTimeGroups() {
        return timeGroups;
    }

    /**
     * 
     * @param timeGroups
     *     The timeGroups
     */
    public void setTimeGroups(List<TimeGroup> timeGroups) {
        this.timeGroups = timeGroups;
    }

    public TimeSet withTimeGroups(List<TimeGroup> timeGroups) {
        this.timeGroups = timeGroups;
        return this;
    }

}
