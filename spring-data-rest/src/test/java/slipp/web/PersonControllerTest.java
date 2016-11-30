package slipp.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import slipp.core.test.AbstractMockMvcTest;
import slipp.domain.Person;

public class PersonControllerTest extends AbstractMockMvcTest {
	@Test
	public void create() throws Exception {
		Person person = new Person("jae sung", "park", null);
		ResultActions actions = performPost("/api/people", person);
		MvcResult result = actions.andReturn();
		String body = result.getResponse().getContentAsString();
		System.out.println("body : " + body);
	}
	
	@Test
	public void findById() throws Exception {
		ResultActions actions = performGet("/api/people/1");
		MvcResult result = actions.andReturn();
		String body = result.getResponse().getContentAsString();
		System.out.println("body : " + body);
	}
}
