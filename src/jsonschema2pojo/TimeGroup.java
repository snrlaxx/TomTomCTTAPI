
package jsonschema2pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeGroup {

    @SerializedName("days")
    @Expose
    private List<String> days = null;
    @SerializedName("times")
    @Expose
    private List<String> times = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TimeGroup() {
    }

    /**
     * 
     * @param days
     * @param times
     */
    public TimeGroup(List<String> days, List<String> times) {
        super();
        this.days = days;
        this.times = times;
    }

    /**
     * 
     * @return
     *     The days
     */
    public List<String> getDays() {
        return days;
    }

    /**
     * 
     * @param days
     *     The days
     */
    public void setDays(List<String> days) {
        this.days = days;
    }

    public TimeGroup withDays(List<String> days) {
        this.days = days;
        return this;
    }

    /**
     * 
     * @return
     *     The times
     */
    public List<String> getTimes() {
        return times;
    }

    /**
     * 
     * @param times
     *     The times
     */
    public void setTimes(List<String> times) {
        this.times = times;
    }

    public TimeGroup withTimes(List<String> times) {
        this.times = times;
        return this;
    }

}
