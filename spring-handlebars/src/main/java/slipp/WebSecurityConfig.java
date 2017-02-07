package slipp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

public abstract class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService); //.passwordEncoder(passwordencoder());
    }
    
    abstract void configureCsrf(HttpSecurity http) throws Exception;
    
    abstract void configureHttpBasic(HttpSecurity http) throws Exception;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        configureCsrf(http);
        configureHttpBasic(http);
        
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

//  @Bean(name = "passwordEncoder")
//  public PasswordEncoder passwordencoder() {
//      return new BCryptPasswordEncoder();
//  }
    
    @Configuration
    @EnableWebSecurity
    @Profile({"local", "production"})
    static class ProductionWebSecurityConfig extends WebSecurityConfig {
        private static final Logger log = LoggerFactory.getLogger(WebSecurityConfig.ProductionWebSecurityConfig.class);
        
        @Override
        void configureCsrf(HttpSecurity http) throws Exception {
            log.info("disable csrf local, production profile");
            http.csrf().disable();
        }

        @Override
        void configureHttpBasic(HttpSecurity http) throws Exception {
        }
    }
    
    @Configuration
    @EnableWebSecurity
    @Profile("test")
    static class TestWebSecurityConfig extends WebSecurityConfig {
        private static final Logger log = LoggerFactory.getLogger(WebSecurityConfig.TestWebSecurityConfig.class);
        
        @Override
        void configureCsrf(HttpSecurity http) throws Exception {
            log.info("disable csrf test profile");
            http.csrf().disable();
        }

        @Override
        void configureHttpBasic(HttpSecurity http) throws Exception {
            http.httpBasic();
        }
    }
}
