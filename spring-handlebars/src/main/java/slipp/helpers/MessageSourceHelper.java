package slipp.helpers;

import java.io.IOException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.github.jknack.handlebars.Options;

import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;

@HandlebarsHelper
public class MessageSourceHelper {
	private static final Logger log = LoggerFactory.getLogger(MessageSourceHelper.class);
	
	@Autowired
	private MessageSource messageSource;

	public CharSequence code(final String code, final Options options) throws IOException {
		log.debug("code : {}", code);
	    Object[] args = options.params;
	    String defaultMessage = options.hash("default");
	    return messageSource.getMessage(code, args, defaultMessage, currentLocale());
	}

	protected Locale currentLocale() {
		return LocaleContextHolder.getLocale();
	}
}
