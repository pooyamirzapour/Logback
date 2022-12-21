package com.bol.logback.converter;

import org.apache.logging.log4j.LogManager;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("/message")
public class MessageController {

    org.apache.logging.log4j.Logger logger2 = LogManager.getLogger();

    @GetMapping("")
    public String getMessage() {

        Map<String, String> user = new HashMap();
        user.put("key1", "Pooya");
        user.put("lastName", "Mirzapour");
        user.put("streetName", "Arthur");
        user.put("houseNumber", "007");
        user.put("postalCode", "3500");
        user.put("deliveryAddress", "so far");
        user.put("comment", "should be shown in the log");
        user.put("email", "pooyamirzapour@gmail.com");
        JSONObject userDetails = new JSONObject(user);

        logger2.info("User Info: {}", userDetails);


        return "Hi";
    }


}
