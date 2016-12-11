package mbta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleRequest {

    @JsonProperty("line")
    private String line;

    @JsonProperty("direction")
    private String direction;

    @JsonProperty("station")
    private String station;

    public ScheduleRequest(String station, String direction, String line) {
        this.station = station;
        this.direction = direction;
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }
}
