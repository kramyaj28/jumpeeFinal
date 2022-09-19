package com.project.jumpee.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.jumpee.exception.UserNotFoundException;
import com.project.jumpee.model.Role;
import com.project.jumpee.model.User;
import com.project.jumpee.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	  User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(""));
          return new org.springframework.security.core.userdetails.User(user.getEmail(),
                  user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
    
    public String registerUser(User user) {
    	userRepository.save(user);
    	return "Successfully registered.";
    }
}
