package slipp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import slipp.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService); //.passwordEncoder(passwordencoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		  .csrf().disable();
		
		http.authorizeRequests()
			.antMatchers("/css/**").permitAll();
		
		http.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/hello").access("hasRole('ROLE_USER')")
				.antMatchers("/boards/**").authenticated()
				.anyRequest().permitAll()
			.and()
				.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("password")
			.and()
				.logout()
				.logoutSuccessUrl("/login?logout")
			.and()
				.exceptionHandling()
				.accessDeniedPage("/403");
	}

//	@Bean(name = "passwordEncoder")
//	public PasswordEncoder passwordencoder() {
//		return new BCryptPasswordEncoder();
//	}
}