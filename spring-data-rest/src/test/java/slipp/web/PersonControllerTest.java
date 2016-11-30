package slipp.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import slipp.domain.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {
	@Autowired MockMvc mvc;
	
	@Autowired ObjectMapper objectMapper;
	
	@Test
	public void create() throws Exception {
		Person person = new Person("jae sung", "park", null);
		String content = objectMapper.writeValueAsString(person);
		MvcResult result = this.mvc.perform(post("/api/people")
				.accept(MediaTypes.HAL_JSON)
				.content(content))
				.andDo(print())
				.andExpect(status().isCreated())
				.andReturn();
		
		String body = result.getResponse().getContentAsString();
		System.out.println("body : " + body);
	}
}
