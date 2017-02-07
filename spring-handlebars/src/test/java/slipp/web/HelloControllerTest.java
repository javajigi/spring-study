package slipp.web;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class HelloControllerTest {
    private static final Logger log = LoggerFactory.getLogger(HelloControllerTest.class);
    
    @Autowired private TestRestTemplate template;
    
    @Before
    public void setup() {
        template = template.withBasicAuth("javajigi", "test");
    }
    
    @Test
    public void hello() {
        ResponseEntity<String> result = template.getForEntity("/hello", String.class);
        log.debug("body : {}", result.getBody());
        assertTrue(result.getBody().contains("/logout"));
    }

}
