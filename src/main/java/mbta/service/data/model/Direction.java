
package mbta.service.data.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "direction_id",
    "direction_name",
    "trip"
})
public class Direction {

    @JsonProperty("direction_id")
    private String directionId;
    @JsonProperty("direction_name")
    private String directionName;
    @JsonProperty("trip")
    private List<Trip> trip = null;

    /**
     * 
     * @return
     *     The directionId
     */
    @JsonProperty("direction_id")
    public String getDirectionId() {
        return directionId;
    }

    /**
     * 
     * @param directionId
     *     The direction_id
     */
    @JsonProperty("direction_id")
    public void setDirectionId(String directionId) {
        this.directionId = directionId;
    }

    /**
     * 
     * @return
     *     The directionName
     */
    @JsonProperty("direction_name")
    public String getDirectionName() {
        return directionName;
    }

    /**
     * 
     * @param directionName
     *     The direction_name
     */
    @JsonProperty("direction_name")
    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    /**
     * 
     * @return
     *     The trip
     */
    @JsonProperty("trip")
    public List<Trip> getTrip() {
        return trip;
    }

    /**
     * 
     * @param trip
     *     The trip
     */
    @JsonProperty("trip")
    public void setTrip(List<Trip> trip) {
        this.trip = trip;
    }

}
