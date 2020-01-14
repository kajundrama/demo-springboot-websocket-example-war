package me.kajundrama.demospringbootwebsocketexamplewar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        Greeting greeting = new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
        logger.info("greeting : '{}'", greeting);
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }


}
