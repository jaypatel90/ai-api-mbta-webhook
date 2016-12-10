package service.data;

import mbta.service.data.StopsDataService;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StopsDataServiceTest {

    @Test
    public void testDataLoad() {
        StopsDataService service = new StopsDataService();
        assertThat(service.findStopId("Malden Center"), equalTo("place-mlmnl"));
        assertThat(service.findStopId("Alewife"), equalTo("place-alfcl"));
    }
}
