package mbta.service;

import com.sun.org.apache.xpath.internal.operations.Mod;
import mbta.service.data.StopsDataService;
import mbta.service.data.model.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MbtaService {

    public static final String DEFAULT_SPEECH = "You can't get they-aaah from hee-yaah.";

    private MbtaClient mbtaClient;
    private StopsDataService stopsDataService;

    public MbtaService() {
        mbtaClient = new MbtaClient();
        stopsDataService = new StopsDataService();
    }

    public String getNextFiveTrainsFromStop(DirectionEnum direction, String stopName, String line) {

        String stopId = stopsDataService.findStopId(stopName);

        if (stopId == null) {
            return DEFAULT_SPEECH;
        }
        MbtaResponse mbtaResponse = mbtaClient.getNextFiveTrainsFromStop(direction, stopId, line);
        Optional<Mode> subwayMode = mbtaResponse.getMode().stream().filter(mode -> "Subway".equals(mode.getModeName())).findFirst();

        if (!subwayMode.isPresent()) {
            return DEFAULT_SPEECH;
        }
        return constructSpeechForNextFiveTrains(subwayMode.get().getRoute());
    }

    private String constructSpeechForNextFiveTrains(List<Route> routes) {
        StringBuilder speechBuilder = new StringBuilder();

        for (Route route: routes) {
            for (Direction direction : route.getDirection()) {
                for (Trip trip: direction.getTrip()) {
                    speechBuilder = speechBuilder.append(trip.getTripName()).append(".").append("\n");
                }
            }
        }
        return speechBuilder.toString();
    }
}
