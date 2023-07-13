package com.hilalsolak.ecommercespring.businessinteraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping("/api/mainpage")
public class MainPageController {

    private final Logger logger = LoggerFactory.getLogger(MainPageController.class);

    @PostMapping("/print")
    @ResponseStatus(HttpStatus.OK)
    public void print(@RequestBody String request) {
        //System.out.println(request);
        logger.info(request);

    }
}