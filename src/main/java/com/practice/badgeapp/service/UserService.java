package com.practice.badgeapp.service;

import com.practice.badgeapp.entity.Roles;
import com.practice.badgeapp.entity.User;
import com.practice.badgeapp.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    UserService(UserRepository repository){
        this.userRepository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        Set<SimpleGrantedAuthority> authoritySet = new HashSet<>();
        for(Roles role : user.getRoles()){
            authoritySet.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), authoritySet);
    }
}
