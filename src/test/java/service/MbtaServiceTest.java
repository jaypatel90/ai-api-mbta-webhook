package service;

import mbta.service.MbtaService;
import mbta.service.data.model.DirectionEnum;
import org.junit.Test;

public class MbtaServiceTest {

    @Test
    public void testGetSchedule() {
        MbtaService mbtaService = new MbtaService();
        String response = mbtaService.getNextFiveTrainsFromStop(DirectionEnum.INBOUND,"Downtown Crossing", "Orange");
        System.out.println(response);
    }
}
