package es.take_a_book.application.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.take_a_book.application.model.Users;
import es.take_a_book.application.service.UserService;

@Service
public class RepositoryUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserService repo;
	
	@Override
	public UserDetails loadUserByUsername(String username)
		throws UsernameNotFoundException {
		
		Users user = repo.findById(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		List<GrantedAuthority> roles = new ArrayList<>();
		System.out.println(user.getRoles().toString());
		for (String role : user.getRoles()) {
			roles.add(new SimpleGrantedAuthority("ROLE_" + role));
		}
		System.out.println(roles.toString());
		return new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(), roles);
	}
}
