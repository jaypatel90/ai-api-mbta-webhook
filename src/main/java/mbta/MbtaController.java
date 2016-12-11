package mbta;

import mbta.model.ApiAiRequest;
import mbta.service.MbtaService;
import mbta.service.data.model.DirectionEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/webhook")
public class MbtaController {

    private MbtaService mbtaService;

    public MbtaController() {
        mbtaService = new MbtaService();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody WebhookResponse webhook(@RequestBody ApiAiRequest request) throws IOException {

        Map<String, String> parameters = request.getResult().getParameters();
        String direction = parameters.get("direction");
        String line = parameters.get("line");
        String station = parameters.get("station");

        String speech = mbtaService.getNextFiveTrainsFromStop(DirectionEnum.lookup(direction),
                station,
                line);
        return new WebhookResponse(speech, speech);
    }
}