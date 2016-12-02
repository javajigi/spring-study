package slipp.domain;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "noAddresses", types = { Person.class })
interface NoAddresses {
	String getFirstName();

	String getLastName();
}
