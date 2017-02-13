package slipp.jackson;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JacksonMappingTest {
	private static final Logger log = LoggerFactory.getLogger(JacksonMappingTest.class);

	@Test
	public void mapping() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
//		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		MyData data = new MyData("Jae Sung");
		String contents = mapper.writeValueAsString(data);
		log.debug("contents : {}", contents);
		MyData result = mapper.readValue(contents, MyData.class);
		assertEquals(data, result);
	}

}
