
package mbta.service.data.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "trip_id",
    "trip_name",
    "sch_arr_dt",
    "sch_dep_dt"
})
public class Trip {

    @JsonProperty("trip_id")
    private String tripId;
    @JsonProperty("trip_name")
    private String tripName;
    @JsonProperty("sch_arr_dt")
    private Long schArrDt;
    @JsonProperty("sch_dep_dt")
    private Long schDepDt;

    /**
     * 
     * @return
     *     The tripId
     */
    @JsonProperty("trip_id")
    public String getTripId() {
        return tripId;
    }

    /**
     * 
     * @param tripId
     *     The trip_id
     */
    @JsonProperty("trip_id")
    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    /**
     * 
     * @return
     *     The tripName
     */
    @JsonProperty("trip_name")
    public String getTripName() {
        return tripName;
    }

    /**
     * 
     * @param tripName
     *     The trip_name
     */
    @JsonProperty("trip_name")
    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    /**
     * 
     * @return
     *     The schArrDt
     */
    @JsonProperty("sch_arr_dt")
    public Long getSchArrDt() {
        return schArrDt;
    }

    /**
     * 
     * @param schArrDt
     *     The sch_arr_dt
     */
    @JsonProperty("sch_arr_dt")
    public void setSchArrDt(Long schArrDt) {
        this.schArrDt = schArrDt;
    }

    /**
     * 
     * @return
     *     The schDepDt
     */
    @JsonProperty("sch_dep_dt")
    public Long getSchDepDt() {
        return schDepDt;
    }

    /**
     * 
     * @param schDepDt
     *     The sch_dep_dt
     */
    @JsonProperty("sch_dep_dt")
    public void setSchDepDt(Long schDepDt) {
        this.schDepDt = schDepDt;
    }

}
