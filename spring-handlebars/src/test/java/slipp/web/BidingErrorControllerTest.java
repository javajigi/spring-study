package slipp.web;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BidingErrorControllerTest {
	private static final Logger log = LoggerFactory.getLogger(BidingErrorControllerTest.class);
	
	@Autowired private TestRestTemplate template;
	
	@Test
	public void binding() throws Exception {
		Person user = new Person("na");
		URI uri = template.postForLocation("/users", user);
		log.debug("body : {}", uri);
	}
}
