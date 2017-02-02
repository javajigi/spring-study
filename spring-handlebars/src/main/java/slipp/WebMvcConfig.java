package slipp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;

import slipp.converter.LocalDateConverter;
import slipp.converter.LocalDateTimeConverter;
import slipp.helpers.MyLogHelper;
import slipp.helpers.SpringSecurityHelper;

@Configuration
@ConditionalOnClass(HandlebarsViewResolver.class)
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new LocalDateConverter("yyyy-MM-dd"));
		registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd'T'HH:mm:ss.SSS"));
	}
	
	@Configuration
	@ConditionalOnClass(SpringSecurityHelper.class)
	static class SpringSecurityHelperAutoConfiguration {
		@Autowired
		private HandlebarsViewResolver handlebarsViewResolver;

		@Autowired
		private SpringSecurityHelper springSecurityHelper;

		@PostConstruct
		public void registerHelper() {
			handlebarsViewResolver.registerHelper(SpringSecurityHelper.NAME, springSecurityHelper);
		}
	}

	@Configuration
	@ConditionalOnClass(MyLogHelper.class)
	static class MyLogHelperAutoConfiguration {
		@Autowired
		private HandlebarsViewResolver handlebarsViewResolver;

		@Autowired
		private MyLogHelper mylogHelper;

		@PostConstruct
		public void registerHelper() {
			handlebarsViewResolver.registerHelper(MyLogHelper.NAME, mylogHelper);
		}
	}
}
