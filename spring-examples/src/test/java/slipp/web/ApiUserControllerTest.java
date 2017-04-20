package slipp.web;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import slipp.domain.User;
import slipp.support.test.AbstractIntegrationTest;

public class ApiUserControllerTest extends AbstractIntegrationTest {
    private static final Logger log = LoggerFactory.getLogger(ApiUserControllerTest.class);

    @Test
    public void bindingError() throws Exception {
        User user = new User("un", "pa", "javajigi", 1);
        ResponseEntity<String> result = template.postForEntity("/api/users", user, String.class);
        log.debug("body : {}", result.getBody());
        assertThat(result.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    }

    @Test
    public void valid() throws Exception {
        User user = new User("username", "pass", "javajigi@slipp.net", 1);
        ResponseEntity<String> result = template.postForEntity("/api/users", user, String.class);
        log.debug("body : {}", result.getBody());
    }
}
