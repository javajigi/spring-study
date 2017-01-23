package slipp.helpers;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

@Component
public class MyLogHelper implements Helper<Object> {
	  public static final Helper<Object> INSTANCE = new MyLogHelper();

	  private final Logger log = LoggerFactory.getLogger(getClass());

	  public static final String NAME = "mylog";

	  @Override
	  public Object apply(final Object context, final Options options)
	      throws IOException {
		  String key = "org.springframework.validation.BindingResult." + options.param(0);
		  log.debug("Key : {}", key);
		  LinkedHashMap map = (LinkedHashMap)context;
		  Object value = map.get(key);
		  log.debug("value : {}", value);
		  Context currentContext = options.context;
		  currentContext.combine("errors", value);
		  log.debug("errors : {}", currentContext.get("errors"));
		  return null;
	  }
	}
