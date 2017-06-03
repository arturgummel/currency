package ee.procedure;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
final String url = "http://www.eestipank.ee/valuutakursid/export/xml/latest";

    @GetMapping(value = "/currencydata", produces = MediaType.APPLICATION_XML_VALUE)
    public String getCurrencyData() {
        RestTemplate restTemplate = new RestTemplate();
        Envelop envelop = restTemplate.getForObject(url, Envelop.class);
        System.err.println(envelop);
        return envelop.toString();
    }
}
