
package tomtomDataFormat;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeSet {

    @SerializedName("@id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("dayToTimeRanges")
    @Expose
    private List<DayToTimeRange> dayToTimeRanges = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DayToTimeRange> getDayToTimeRanges() {
        return dayToTimeRanges;
    }

    public void setDayToTimeRanges(List<DayToTimeRange> dayToTimeRanges) {
        this.dayToTimeRanges = dayToTimeRanges;
    }

}
