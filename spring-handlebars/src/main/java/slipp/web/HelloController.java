package slipp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);
    
	@GetMapping("/hello")
	public String hello() {
	    log.debug("Call Hello World!");
		return "hello";
	}
}
