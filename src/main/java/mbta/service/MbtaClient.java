package mbta.service;

import mbta.service.data.model.DirectionEnum;
import mbta.service.data.model.MbtaResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

public class MbtaClient {

    private static final String SCHEDULE_BY_STOP_ENDPOINT = "http://realtime.mbta.com/developer/api/v2/schedulebystop";
    private RestTemplate restTemplate;

    public MbtaClient() {
        restTemplate = new RestTemplate();
    }

    public MbtaResponse getNextFiveTrainsFromStop(DirectionEnum direction, String stopId, String line) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("stop", stopId);

        if (!line.isEmpty()) {
            queryMap.put("route", line);
        }

        if (!direction.getValue().isEmpty()) {
            queryMap.put("direction", direction.getValue());
        }

        HttpEntity<MbtaResponse> response = sendRequest(SCHEDULE_BY_STOP_ENDPOINT, queryMap, MbtaResponse.class);
        return response.getBody();
    }

    private HttpEntity sendRequest(String url, Map<String, String> requestQueryParams, Class responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);


        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("api_key", System.getenv("MBTA_API_KEY"))
                .queryParam("format", "json");

        requestQueryParams.entrySet().forEach(param ->
                builder.queryParam(param.getKey(), param.getValue()));

        HttpEntity<?> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                responseType);
    }
}
