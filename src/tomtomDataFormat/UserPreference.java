
package tomtomDataFormat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserPreference {

    @SerializedName("distanceUnit")
    @Expose
    private String distanceUnit;

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

}
