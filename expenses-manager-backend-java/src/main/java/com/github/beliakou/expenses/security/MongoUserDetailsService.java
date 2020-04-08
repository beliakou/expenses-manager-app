package com.github.beliakou.expenses.security;

import com.github.beliakou.expenses.domain.User;
import com.github.beliakou.expenses.exception.UserNotFoundException;
import com.github.beliakou.expenses.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collections;
import java.util.List;

public class MongoUserDetailsService implements UserDetailsService {

    private UserRepository repository;

    public MongoUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        User user = repository.findUser(username).orElseThrow(() -> new UserNotFoundException("User not found"));

        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("user"));
        return new UserPrincipal(user.name(), user.password(), authorities);
    }
}