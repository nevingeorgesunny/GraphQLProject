package com.graphqljava.tutorial.bookDetails.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author nevinsunny
 * date 06/03/23
 * time 10:17 PM
 */
public class AuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        ObjectMapper mapper = new ObjectMapper();
        String token = req.getHeader("Authorization");
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();

        String header = new String(decoder.decode(chunks[0]));
        String payload = new String(decoder.decode(chunks[1]));

        Map<String, String> payloadMap = mapper.readValue(payload, Map.class);

        List<String> userGroups =(List<String>) (Object)payloadMap.get("cognito:groups");


        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                new org.springframework.security.core.userdetails.User("nevin", "pass", getAuthority(userGroups)),
                "",
                getAuthority(userGroups));

        //UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(req, res);
    }

    private Set<SimpleGrantedAuthority> getAuthority(List<String> userGroups) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        for(String userGroup : userGroups) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userGroup.toUpperCase()));
        }

        return authorities;
    }
}
