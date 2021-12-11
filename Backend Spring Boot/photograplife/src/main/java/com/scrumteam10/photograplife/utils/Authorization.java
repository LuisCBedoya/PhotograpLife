package com.scrumteam10.photograplife.utils;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import io.jsonwebtoken.Jwts;

// @Component
public class Authorization implements Filter {
    
    public static final String KEY="asdasdasdsadas";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
                HttpServletRequest httpServletRequest=(HttpServletRequest) request;

                HttpServletResponse httpServletResponse=(HttpServletResponse) response;
                httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
                httpServletResponse.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
                

                String url = httpServletRequest.getRequestURI();
                if(url.contains("/api/publications") || url.contains("/api/user/login") || url.contains("/api/user")|| url.contains("/user/upload")|| url.contains("index")){
                    chain.doFilter(request, response);
                }else{
                    String hash = httpServletRequest.getHeader("Authorization");
                    if(hash == null || hash.trim().equals("")){
                        response.setContentType("application/json");
                        String body ="{\"Authorization\":\"No\"}";
                        response.getWriter().write(body);
                    }
                    try {
                        Jws<Claims> claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(hash);
                        if((url.contains("/api/verificar")||url.contains("/api/images"))&&(!claims.getBody().get("userName").equals(""))){
                            chain.doFilter(request, response);    
                        }
                    } catch (Exception e) {
                        response.setContentType("application/json");
                        String body ="{\"Authorization\":\"TOKEN No VALIDO\"}";
                        response.getWriter().write(body);
                    }
                }
        
    }
}
