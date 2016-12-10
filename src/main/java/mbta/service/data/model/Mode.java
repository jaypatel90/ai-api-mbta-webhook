
package mbta.service.data.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "route_type",
    "mode_name",
    "route"
})
public class Mode {

    @JsonProperty("route_type")
    private String routeType;
    @JsonProperty("mode_name")
    private String modeName;
    @JsonProperty("route")
    private List<Route> route = null;

    /**
     * 
     * @return
     *     The routeType
     */
    @JsonProperty("route_type")
    public String getRouteType() {
        return routeType;
    }

    /**
     * 
     * @param routeType
     *     The route_type
     */
    @JsonProperty("route_type")
    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    /**
     * 
     * @return
     *     The modeName
     */
    @JsonProperty("mode_name")
    public String getModeName() {
        return modeName;
    }

    /**
     * 
     * @param modeName
     *     The mode_name
     */
    @JsonProperty("mode_name")
    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    /**
     * 
     * @return
     *     The route
     */
    @JsonProperty("route")
    public List<Route> getRoute() {
        return route;
    }

    /**
     * 
     * @param route
     *     The route
     */
    @JsonProperty("route")
    public void setRoute(List<Route> route) {
        this.route = route;
    }

}
