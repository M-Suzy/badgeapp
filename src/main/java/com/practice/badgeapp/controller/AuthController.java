package com.practice.badgeapp.controller;

import com.practice.badgeapp.entity.AuthRequest;
import com.practice.badgeapp.entity.AuthResponse;
import com.practice.badgeapp.service.UserService;
import com.practice.badgeapp.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostMapping(value = "/auth")
    private ResponseEntity createAuthToken(@RequestBody AuthRequest authRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authRequest.getUsername(),  authRequest.getPassword()
            ));
        } catch (BadCredentialsException ex){
            throw new BadCredentialsException("Invalid username or password");
        }
        final UserDetails user = userService.loadUserByUsername(authRequest.getUsername());
        final String jwtToken = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(jwtToken));
    }
}
