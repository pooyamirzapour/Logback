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

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

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
        user.put("email", "pooyamirzapour@gmail.com");
        JSONObject userDetails = new JSONObject(user);

        logger.info("User Info: {}", userDetails);

        //myTest();

        return "Hi";
    }

    public static void myTest() {
        logger.info("this is my info message");
        logger.info("This is debug message");
        logger.info(
                "Passed to server::0084USER:17603,IP:0:0:0:0:0:0:0:1,3425,Credit Card 1:1000002367844224,3425,Credit Card2:1000002367844224 , CVV:234,SSN:123456789");

    }
}
