
package tomtomDataFormat;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DayToTimeRange {

    @SerializedName("dayOfWeek")
    @Expose
    private String dayOfWeek;
    @SerializedName("timeRanges")
    @Expose
    private List<String> timeRanges = null;

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<String> getTimeRanges() {
        return timeRanges;
    }

    public void setTimeRanges(List<String> timeRanges) {
        this.timeRanges = timeRanges;
    }

}
