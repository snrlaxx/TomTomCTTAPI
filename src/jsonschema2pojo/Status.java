
package jsonschema2pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("responseStatus")
    @Expose
    private String responseStatus;
    @SerializedName("jobId")
    @Expose
    private String jobId;
    @SerializedName("urls")
    @Expose
    private List<String> urls = null;

    /**
     * 
     * @return
     *     The responseStatus
     */
    public String getResponseStatus() {
        return responseStatus;
    }

    /**
     * 
     * @param responseStatus
     *     The responseStatus
     */
    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    /**
     * 
     * @return
     *     The jobId
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * 
     * @param jobId
     *     The jobId
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    /**
     * 
     * @return
     *     The urls
     */
    public List<String> getUrls() {
        return urls;
    }

    /**
     * 
     * @param urls
     *     The urls
     */
    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

}
