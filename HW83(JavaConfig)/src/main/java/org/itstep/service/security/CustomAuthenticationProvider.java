package org.itstep.service.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {
    final CustomUserDetailsService customDetailsService;

    @Autowired
    public CustomAuthenticationProvider(CustomUserDetailsService customDetailsService) {
        this.customDetailsService = customDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        UserDetails userDetails = null;
        try {
            userDetails = customDetailsService.loadUserByUsername(username);
            if(password.equals(userDetails.getPassword())){
                throw new BadCredentialsException("User not found: " + password);
            }
        } catch (Exception e) {
            log.error("User not found. + password");
            throw new BadCredentialsException("User not found", e);
        }
        return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.equals(aClass);
    }
}
