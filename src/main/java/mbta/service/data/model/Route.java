
package mbta.service.data.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "route_id",
    "route_name",
    "direction"
})
public class Route {

    @JsonProperty("route_id")
    private String routeId;
    @JsonProperty("route_name")
    private String routeName;
    @JsonProperty("direction")
    private List<Direction> direction = null;

    /**
     * 
     * @return
     *     The routeId
     */
    @JsonProperty("route_id")
    public String getRouteId() {
        return routeId;
    }

    /**
     * 
     * @param routeId
     *     The route_id
     */
    @JsonProperty("route_id")
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    /**
     * 
     * @return
     *     The routeName
     */
    @JsonProperty("route_name")
    public String getRouteName() {
        return routeName;
    }

    /**
     * 
     * @param routeName
     *     The route_name
     */
    @JsonProperty("route_name")
    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    /**
     * 
     * @return
     *     The direction
     */
    @JsonProperty("direction")
    public List<Direction> getDirection() {
        return direction;
    }

    /**
     * 
     * @param direction
     *     The direction
     */
    @JsonProperty("direction")
    public void setDirection(List<Direction> direction) {
        this.direction = direction;
    }

}
