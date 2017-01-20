package slipp.helpers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.TagType;

@Component
public class MyLogHelper implements Helper<Object> {

	  /**
	   * A singleton instance of this helper.
	   */
	  public static final Helper<Object> INSTANCE = new MyLogHelper();

	  /** The logging system. */
	  private final Logger log = LoggerFactory.getLogger(getClass());

	  /**
	   * The helper's name.
	   */
	  public static final String NAME = "mylog";

	  @Override
	  public Object apply(final Object context, final Options options)
	      throws IOException {
	    StringBuilder sb = new StringBuilder();
	    String level = options.hash("level", "info");
	    TagType tagType = options.tagType;
	    if (tagType.inline()) {
	      sb.append(context);
	      for (int i = 0; i < options.params.length; i++) {
	        sb.append(" ").append(options.param(i).toString());
	      }
	    } else {
	      sb.append(options.fn());
	    }
	    switch (level) {
	      case "error":
	        log.error(sb.toString().trim());
	        break;
	      case "debug":
	        log.debug(sb.toString().trim());
	        break;
	      case "warn":
	        log.warn(sb.toString().trim());
	        break;
	      case "trace":
	        log.trace(sb.toString().trim());
	        break;
	      default:
	        log.info(sb.toString().trim());
	    }
	    return null;
	  }
	}
