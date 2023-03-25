package es.take_a_book.application.security;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public RepositoryUserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10, new SecureRandom());
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		
		//Security configuration
		//Public pages
		http.authorizeRequests().antMatchers("/home").permitAll()
					.antMatchers("/authors").permitAll()
					.antMatchers("authors/*").permitAll()
					.antMatchers("/books").permitAll()
					.antMatchers("/books/*").permitAll()
					.antMatchers("/signup_presentation").permitAll()
					.antMatchers("/signup_form").permitAll()
					.antMatchers("/users/login_template").permitAll()
					.antMatchers("/users/login_error").permitAll()
					.antMatchers("/users/logout").permitAll()
					.antMatchers("/test/*").permitAll();

		
		//Private pages
		http.authorizeRequests().antMatchers("/orders").hasAnyRole("USER")
					.antMatchers("/loan").hasAnyRole("USER")
					.antMatchers("/loan/*").hasAnyRole("USER")
					.antMatchers("/purchase").hasAnyRole("USER")
					.antMatchers("/purchase/cart").hasAnyRole("USER")
					.antMatchers("/books/*/loan").hasAnyRole("USER")
					.antMatchers("/books/*/purchase").hasAnyRole("USER");
					
				
		//http.authorizeRequests().antMatchers("/users/signup_form").hasAnyRole("USER");
		//http.authorizeRequests().antMatchers("/users/login_form").hasAnyRole("USER");
		
		http.authorizeRequests().antMatchers("/authors/new").hasAnyRole("ADMIN")
					.antMatchers("/authors/*/edit").hasAnyRole("ADMIN")
					.antMatchers("/authors/*/remove_confirm").hasAnyRole("ADMIN")
					.antMatchers("/books/new").hasAnyRole("ADMIN")
					.antMatchers("/books/*/edit").hasAnyRole("ADMIN")
					.antMatchers("/books/*/edit/image").hasAnyRole("ADMIN")
					.antMatchers("/books/*/remove_confirm").hasAnyRole("ADMIN");
					
		//Login form
		http.formLogin().loginPage("/users/login_template");
		http.formLogin().usernameParameter("username");
		http.formLogin().passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/home");
		http.formLogin().failureUrl("/users/login_error");
		
		// Logout
		http.logout().logoutUrl("/users/logout")
					.logoutSuccessUrl("/home");
		
		// Disable CSRF at the moment
		//http.csrf().disable();

	}
	
	
}