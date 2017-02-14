package slipp.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import slipp.support.test.AbstractIntegrationTest;
import slipp.support.test.HtmlFormDataBuilder;

public class AttachmentControllerTest extends AbstractIntegrationTest {
	private static final Logger log = LoggerFactory.getLogger(AttachmentControllerTest.class);
	
	@Test
	public void download() throws Exception {
		ResponseEntity<String> result = template.getForEntity("/attachments", String.class);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		log.debug("body : {}", result.getBody());
	}
	
	@Test
	public void upload() throws Exception {
		HttpEntity<MultiValueMap<String, Object>> request = HtmlFormDataBuilder
			.multipartFormData()
			.addParameter("file", new ClassPathResource("logback.xml"))
			.build();
		ResponseEntity<String> result = template.postForEntity("/attachments", request, String.class);
        assertEquals(HttpStatus.FOUND, result.getStatusCode());
	}
}
