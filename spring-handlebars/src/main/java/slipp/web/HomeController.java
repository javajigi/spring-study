package slipp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import slipp.domain.MyDate;

@Controller
public class HomeController {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/main")
	public String inheritance() {
		return "main";
	}
	
	@GetMapping("/date")
	public String date(MyDate date) {
		log.debug("date : {}", date);
		return "home";
	}
}
