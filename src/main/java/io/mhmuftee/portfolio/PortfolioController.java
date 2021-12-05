package io.mhmuftee.portfolio;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioController {
    @CrossOrigin(origins = "http://192.168.2.124:9000/")
    @GetMapping(value = "/")
    String root(){
        return "To be implemented";
    }
}
