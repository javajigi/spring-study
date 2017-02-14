package slipp.web;

import static org.junit.Assert.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import slipp.support.test.AbstractIntegrationTest;
import slipp.support.test.HtmlFormDataBuilder;

public class UserControllerTest extends AbstractIntegrationTest {
	private static final Logger log = LoggerFactory.getLogger(UserControllerTest.class);
	
	@Test
	public void create() {
        String userId = RandomStringUtils.randomAlphanumeric(10).toUpperCase();
        HttpEntity<MultiValueMap<String, String>> request = HtmlFormDataBuilder
			.urlEncodedForm()
			.addParameter("userId",  userId + "@slipp.net")
			.addParameter("userName", "Jae Sung")
			.addParameter("password", "password!@")
			.build();
        
        ResponseEntity<String> result = template.postForEntity("/users", request, String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        log.debug("body : {}", result.getBody());
	}

}
