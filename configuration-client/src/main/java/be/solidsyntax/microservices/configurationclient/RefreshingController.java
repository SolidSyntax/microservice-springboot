package be.solidsyntax.microservices.configurationclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class RefreshingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RefreshingController.class);

    @GetMapping("/hello")
    public String hello(@Value("${configuration.hello:}") String hello) {
        return hello;
    }
}
