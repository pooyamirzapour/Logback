package com.bol.logback;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("/message")
@RequestMapping("/message")
public class MessageController {

    private static final Logger parentLogger = LoggerFactory.getLogger(MessageController.class);

    @GetMapping("")
    public String getMessage() {
        Map<String, String> user = new HashMap();
        user.put("firstName", "Pooya");
        user.put("lastName", "Mirzapour");
        user.put("streetName", "Arthur");
        user.put("houseNumber", "007");
        user.put("postalCode", "3500");
        user.put("deliveryAddress", "so far");
        user.put("comment", "should be shown in the log");
        JSONObject userDetails = new JSONObject(user);

        parentLogger.info("User Info: {}", userDetails);
        return "Hi";
    }
}
