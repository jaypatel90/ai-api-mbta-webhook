package mbta;

import mbta.service.MbtaService;
import mbta.service.data.model.DirectionEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/webhook")
public class MbtaController {

    private MbtaService mbtaService;

    public MbtaController() {
        mbtaService = new MbtaService();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody WebhookResponse webhook(@RequestParam String station,
                                                 @RequestParam String line,
                                                 @RequestParam String direction){

        String speech = mbtaService.getNextFiveTrainsFromStop(DirectionEnum.lookup(direction), station, line);
        return new WebhookResponse(speech, speech);
    }
}