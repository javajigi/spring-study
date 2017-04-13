package slipp.jackson;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JacksonMappingTest {
	private static final Logger log = LoggerFactory.getLogger(JacksonMappingTest.class);
	
	private ObjectMapper mapper;
	
	@Before
	public void setup() {
		mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
	}

	@Test
	public void mapping() throws Exception {
		MyData data = new MyData("Jae Sung");
		String contents = mapper.writeValueAsString(data);
		log.debug("contents : {}", contents);
		MyData result = mapper.readValue(contents, MyData.class);
		assertEquals(data, result);
	}
	
	@Test
	public void simple() throws Exception {
		Map<String, String> data = new HashMap<>();
		data.put("name", "jaesung");
		String result = mapper.writeValueAsString(data);
		log.debug("result : {}", result);
	}
}
