package slipp.web;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import slipp.domain.User;

@Controller
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/users")
	public String users(@Valid @RequestBody User user, BindingResult result, Model model) {
		log.debug("user : {}", user);
		
		List<ObjectError> errors = result.getAllErrors();
		for (ObjectError error : errors) {
			FieldError fieldError = (FieldError)error;
			log.debug("field : {}, codes : {}", fieldError.getField(), fieldError.getCodes());
			error.getCodes();
		}
		model.addAttribute("errors", errors);
		return "errors";
	}
}
