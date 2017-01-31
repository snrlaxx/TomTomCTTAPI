
package jsonschema2pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("jobId")
    @Expose
    private String jobId;
    @SerializedName("responseStatus")
    @Expose
    private String responseStatus;
    @SerializedName("messages")
    @Expose
    private List<String> messages = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Response() {
    }

    /**
     * 
     * @param jobId
     * @param responseStatus
     * @param messages
     */
    public Response(String jobId, String responseStatus, List<String> messages) {
        super();
        this.jobId = jobId;
        this.responseStatus = responseStatus;
        this.messages = messages;
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

    public Response withJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

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

    public Response withResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
        return this;
    }

    /**
     * 
     * @return
     *     The messages
     */
    public List<String> getMessages() {
        return messages;
    }

    /**
     * 
     * @param messages
     *     The messages
     */
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public Response withMessages(List<String> messages) {
        this.messages = messages;
        return this;
    }

}
