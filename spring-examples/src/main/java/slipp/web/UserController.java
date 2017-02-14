package slipp.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import slipp.domain.User;

@Controller
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
	@PostMapping("/users")
	public String users(@Valid User user) {
		log.debug("user : {}", user);
		return "home";
	}
}
