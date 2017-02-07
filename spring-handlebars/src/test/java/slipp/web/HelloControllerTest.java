package slipp.web;

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
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {
    private static final Logger log = LoggerFactory.getLogger(HelloControllerTest.class);
    
    @Autowired private TestRestTemplate template;
    
    @Before
    public void setup() {
        template.withBasicAuth("javajigi", "test");
    }
    
    @Test
    public void hello() {
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("username", "javajigi");
//        params.add("password", "test");
//        ResponseEntity<String> loginResult = template.postForEntity("/login", params, String.class);
//        HttpHeaders headers = loginResult.getHeaders();
//        log.debug("cookies : {}", headers.get("Set-Cookie"));
        ResponseEntity<String> result = template.getForEntity("/hello", String.class);
        log.debug("body : {}", result.getBody());
    }

}
