package com.employee.service.Filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class MyFilter extends OncePerRequestFilter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String authHeader = request.getHeader("Authorization");
            String baseCred = authHeader.substring("Basic".length()).trim();
            byte[] credDecoded = Base64.getDecoder().decode(baseCred);
            String cred = new String(credDecoded, StandardCharsets.UTF_8);
            String[] credArray = cred.split(":");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credArray[0], credArray[1]));
            filterChain.doFilter(request, response);
        } catch (ServletException | IOException | InternalAuthenticationServiceException | BadCredentialsException e) {
            throw new BadCredentialsException("Authorization Failed");
        }
    }
}

