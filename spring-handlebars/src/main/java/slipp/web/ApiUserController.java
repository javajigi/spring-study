package slipp.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import slipp.domain.User;
import slipp.validate.RestResponse;

@RestController
public class ApiUserController {
	private static final Logger log = LoggerFactory.getLogger(ApiUserController.class);
	
	@PostMapping("/api/users")
	public ResponseEntity<?> users(@Valid @RequestBody User user) {
		log.debug("user : {}", user);
		RestResponse response = new RestResponse();
		response.addAttribute("user", user);
		return ResponseEntity.ok(response);
	}
}
