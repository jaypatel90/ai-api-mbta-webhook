package mbta.service.data;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StopsDataService {

    private Map<String, String> stopsMap = new HashMap<>();

    public StopsDataService() {
        this.stopsMap = this.stopsMap.isEmpty() ? populateStopsMap() : this.stopsMap;
    }

    private Map<String, String> populateStopsMap() {
        Map<String, String> map = new HashMap<>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("stops.csv").getFile());

        try {

            CSVReader reader = new CSVReader(new FileReader(file));


            String[] row;
            reader.readNext();

            while ((row = reader.readNext()) != null) {

                String stationName = row[2];
                String stopId = row[0];
                String parentStopId = row[9];

                if (parentStopId != null && !parentStopId.isEmpty()) {
                    stopId = parentStopId;
                }
                map.put(stationName, stopId);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    public String findStopId(String stopName) {
        return stopsMap.get(stopName);
    }

}
