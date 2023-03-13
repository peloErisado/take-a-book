package es.take_a_book.application.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	
	//encripta la contraseña 
	@Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	 PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	 String encodedPassword = encoder.encode("pass");

	 auth.inMemoryAuthentication().withUser("user").password(encodedPassword).roles("USER");
	 }
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		
		//Security configuration
		
		//Public pages
		http.authorizeRequests().antMatchers("/home").permitAll();
		http.authorizeRequests().antMatchers("/authors").permitAll();
		http.authorizeRequests().antMatchers("authors/*").permitAll();
		http.authorizeRequests().antMatchers("/books").permitAll();
		http.authorizeRequests().antMatchers("/books/*").permitAll();
		http.authorizeRequests().antMatchers("/signup_presentation").permitAll();
		http.authorizeRequests().antMatchers("/login_template").permitAll();
		
		//Private pages
		http.authorizeRequests().antMatchers("/orders").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/loan").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/loan/*").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/purchase").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/books/*/loan").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/books/*/purchase").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/users/signup_form").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/users/login_form").hasAnyRole("USER");
		
		http.authorizeRequests().antMatchers("/authors/new").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/authors/*/edit").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/authors/*/remove_confirm").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/books/new").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/books/*/edit").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/books/*/remove_confirm").hasAnyRole("ADMIN");
		
	}
	
	
}