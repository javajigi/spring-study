package slipp.core.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AbstractMockMvcTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;

	protected ResultActions performGet(String url) throws Exception {
		return this.mockMvc.perform(get(url))
				.andDo(print())
				.andExpect(status().isOk());
	}

	protected ResultActions performPost(String url, Object content) throws Exception {
		return this.mockMvc.perform(
				post(url)
						.contentType(MediaTypes.HAL_JSON)
						.content(this.objectMapper.writeValueAsString(content)))
				.andDo(print())
				.andExpect(status().isCreated());
	}

	protected ResultActions performPatch(String url, Object content) throws Exception {
		return this.mockMvc.perform(
				patch(url)
						.contentType(MediaTypes.HAL_JSON)
						.content(this.objectMapper.writeValueAsString(content)))
				.andDo(print())
				.andExpect(status().isNoContent());
	}

	protected String getLocation(String url, Object content) throws Exception {
		return performPost(url, content)
				.andReturn()
				.getResponse().getRedirectedUrl();
	}
}
