
package jsonschema2pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DateRange {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DateRange() {
    }

    /**
     * 
     * @param name
     * @param from
     * @param to
     */
    public DateRange(String name, String from, String to) {
        super();
        this.name = name;
        this.from = from;
        this.to = to;
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

    public DateRange withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The from
     */
    public String getFrom() {
        return from;
    }

    /**
     * 
     * @param from
     *     The from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    public DateRange withFrom(String from) {
        this.from = from;
        return this;
    }

    /**
     * 
     * @return
     *     The to
     */
    public String getTo() {
        return to;
    }

    /**
     * 
     * @param to
     *     The to
     */
    public void setTo(String to) {
        this.to = to;
    }

    public DateRange withTo(String to) {
        this.to = to;
        return this;
    }

}
