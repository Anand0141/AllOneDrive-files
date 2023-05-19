package com.example.service;



import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.Users;
import com.example.repository.UserReository;

@Service
public class IUserServiceImpl implements IUserService ,UserDetailsService {
	
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	
	@Autowired
	public UserReository userRepository;
	
	int count=0;
	@Override
	public Integer SaveUser(Users user) {
		String password=user.getPwd();
		String encoder=pwdEncoder.encode(password);
		user.setPwd(encoder);
		Users user2 = userRepository.save(user);
		 if(user2!=null) {
			 count++;
		 }
		return count;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		// load model class user object by emailid (username) 
	
		Optional<Users> findByEmail = userRepository.findByEmail(username);
		
		//Users user=null;
		
		UserDetails usr;
		
		if(findByEmail.isEmpty()) {
			throw new UsernameNotFoundException("user not found "+username);
		}
		else {
			Users user=findByEmail.get();
			
			List<String> roles = user.getRoles();
			
			Set<GrantedAuthority> gas=new HashSet<>();
			
			for(String role:roles) {
				gas.add(new SimpleGrantedAuthority(role));
			}
			
			usr = new User(username, user.getPwd(), gas);		
			
		}
		return usr;
	}

}
