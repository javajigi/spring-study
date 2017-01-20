package slipp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;

import slipp.helpers.SpringSecurityHelper;

 @Configuration
 @ConditionalOnClass(HandlebarsViewResolver.class)
public class WebMvcConfig {
	@Configuration
	@ConditionalOnClass(SpringSecurityHelper.class)
    static class JsonHelperAutoConfiguration {
        @Autowired
        private HandlebarsViewResolver handlebarsViewResolver;
        
        @Autowired
        private SpringSecurityHelper springSecurityHelper;

        @PostConstruct
        public void registerHelper() {
            handlebarsViewResolver.registerHelper(SpringSecurityHelper.NAME, springSecurityHelper);
        }
    }
}
