package slipp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class MyHandlebarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyHandlebarsApplication.class, args);
	}
	
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("classpath:messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    messageSource.setCacheSeconds(30);
	    return messageSource;
	}
	
	@Bean
	public MessageSourceAccessor msa(MessageSource messageSource) {
	    return new MessageSourceAccessor(messageSource);
	}
}
