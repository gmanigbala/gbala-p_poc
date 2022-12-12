package com.javainuse.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.config.JwtTokenUtil;
import com.javainuse.model.JwtRequest;
import com.javainuse.model.JwtResponse;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {

		
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		System.out.println("createAuthenticationToken...3" + userDetails);
		final String token = jwtTokenUtil.generateToken(userDetails);
		System.out.println("createAuthenticationToken...4"+token);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		
		System.out.println("createAuthenticationToken...1");
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		System.out.println("createAuthenticationToken...2.0.1..." + username);
		try {
			
			Authentication auth = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(username, password));
			
			System.out.println("ddddd.."+auth.isAuthenticated());
			SecurityContext sc = SecurityContextHolder.getContext();
			sc.setAuthentication(auth);
			
			System.out.println("createAuthenticationToken...2.1");
		} catch (DisabledException e) {
			System.out.println("createAuthenticationToken...2.3");
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			System.out.println("createAuthenticationToken...2.2");
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
