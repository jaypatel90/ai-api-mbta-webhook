package mbta;

import mbta.service.MbtaService;
import mbta.service.data.model.DirectionEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/webhook")
public class MbtaController {

    private MbtaService mbtaService;

    public MbtaController() {
        mbtaService = new MbtaService();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody WebhookResponse webhook(@RequestBody ScheduleRequest scheduleRequest){

        String speech = mbtaService.getNextFiveTrainsFromStop(DirectionEnum.lookup(scheduleRequest.getDirection()),
                scheduleRequest.getStation(),
                scheduleRequest.getLine());
        return new WebhookResponse(speech, speech);
    }
}