package slipp.web;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AttachmentControllerTest {
	private static final Logger log = LoggerFactory.getLogger(AttachmentControllerTest.class);
	
	@Autowired private TestRestTemplate template;
	
	@Test
	public void download() throws Exception {
		ResponseEntity<String> result = template.getForEntity("/attachments", String.class);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		log.debug("body : {}", result.getBody());
	}
}
