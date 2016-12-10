
package mbta.service.data.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "stop_id",
    "stop_name",
    "mode"
})
public class MbtaResponse {

    @JsonProperty("stop_id")
    private String stopId;
    @JsonProperty("stop_name")
    private String stopName;
    @JsonProperty("mode")
    private List<Mode> mode = null;

    /**
     * 
     * @return
     *     The stopId
     */
    @JsonProperty("stop_id")
    public String getStopId() {
        return stopId;
    }

    /**
     * 
     * @param stopId
     *     The stop_id
     */
    @JsonProperty("stop_id")
    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    /**
     * 
     * @return
     *     The stopName
     */
    @JsonProperty("stop_name")
    public String getStopName() {
        return stopName;
    }

    /**
     * 
     * @param stopName
     *     The stop_name
     */
    @JsonProperty("stop_name")
    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    /**
     * 
     * @return
     *     The mode
     */
    @JsonProperty("mode")
    public List<Mode> getMode() {
        return mode;
    }

    /**
     * 
     * @param mode
     *     The mode
     */
    @JsonProperty("mode")
    public void setMode(List<Mode> mode) {
        this.mode = mode;
    }

}
