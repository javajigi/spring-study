package slipp.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HomeControllerTest {
	private static final Logger log = LoggerFactory.getLogger(HomeControllerTest.class);
	
	@Autowired private TestRestTemplate template;
	
	@Test
	public void home() throws Exception {
		ResponseEntity<String> result = template.getForEntity("/", String.class);
		log.debug("body : {}", result.getBody());
	}
	
	@Test
	public void main() throws Exception {
		ResponseEntity<String> result = template.getForEntity("/main", String.class);
		log.debug("body : {}", result.getBody());	
	}
	
	@Test
	public void dateTypeConversion() throws Exception {
		ResponseEntity<String> result = template.getForEntity("/date?date=2017-02-03&dateTime=2017-02-03T02:50:12.208", String.class);
		log.debug("body : {}", result.getBody());
	}
}
