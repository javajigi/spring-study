package slipp.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import slipp.domain.User;

@Controller
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/users")
	public String users(@Valid @RequestBody User user, Model model) {
		log.debug("user : {}", user);
		return "errors";
	}
	
	@GetMapping("/login")
	public String logineForm() {
		return "login";
	}
}
