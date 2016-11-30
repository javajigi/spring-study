package slipp.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "virtual", types = { Person.class })
public interface VirtualProject {
	@Value("#{target.firstName}, #{target.lastName}")
	String getFullName();
}
