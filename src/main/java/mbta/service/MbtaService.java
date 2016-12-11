package mbta.service;

import com.sun.org.apache.xpath.internal.operations.Mod;
import mbta.service.data.StopsDataService;
import mbta.service.data.model.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MbtaService {

    public static final String DEFAULT_SPEECH = "Sorry, could not understand. Maybe you have an accent?";
    public static final String STOP_NOT__FOUND_SPEECH = "Chutye, tere baap ne station banaaya hai?";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
    private static final int MAX_COUNT = 5;

    private MbtaClient mbtaClient;
    private StopsDataService stopsDataService;

    public MbtaService() {
        mbtaClient = new MbtaClient();
        stopsDataService = new StopsDataService();
    }

    public String getNextFiveTrainsFromStop(DirectionEnum direction, String stopName, String line) {

        String stopId = stopsDataService.findStopId(stopName);

        if (stopId == null) {
            return STOP_NOT__FOUND_SPEECH;
        }
        MbtaResponse mbtaResponse = mbtaClient.getNextFiveTrainsFromStop(direction, stopId, line);
        Optional<Mode> subwayMode = mbtaResponse.getMode().stream().filter(mode -> "Subway".equals(mode.getModeName())).findFirst();

        return subwayMode.map(mode -> constructSpeechForNextFiveTrains(mode.getRoute())).orElse(DEFAULT_SPEECH);
    }

    private String constructSpeechForNextFiveTrains(List<Route> routes) {
        StringBuilder speechBuilder = new StringBuilder();

        for (Route route: routes) {

            for (Direction direction : route.getDirection()) {
                speechBuilder  = speechBuilder.append("For ")
                        .append(DirectionEnum.lookupFromDirectionNumber(direction.getDirectionId()))
                        .append(", ");
                boolean found = false;
                List<Trip> trips = direction.getTrip();
                int limit = Math.min(trips.size(), MAX_COUNT);
                for (int i = 0; i < limit ; i ++) {
                    Trip trip = trips.get(i);

                    if ( i == 0) {
                        speechBuilder = speechBuilder.append("there are trains on the following times:");
                    }
                    String serviceTo = trip.getTripName().substring(trip.getTripName().indexOf("to"));
                    speechBuilder = speechBuilder.append(findTime(trip.getSchArrDt())).append(" ").append(serviceTo);

                    if (i != limit - 1) {
                        speechBuilder = speechBuilder.append(", ");
                    }

                    found = true;
                }

                if (!found) {
                    speechBuilder = speechBuilder.append("No train found.");
                } else {
                    speechBuilder = speechBuilder.append(".\n");
                }

            }
        }
        return speechBuilder.toString();
    }

    private String findTime(Long epoch) {
        Instant instant = Instant.ofEpochSecond(epoch);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of("America/New_York"));

        return zonedDateTime.toLocalDateTime().format(formatter);
    }
}
