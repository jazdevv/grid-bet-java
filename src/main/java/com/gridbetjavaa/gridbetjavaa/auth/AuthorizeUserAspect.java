package com.gridbetjavaa.gridbetjavaa.auth;

import com.gridbetjavaa.gridbetjavaa.utils.JwtUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;

@Aspect
@Component
public class AuthorizeUserAspect {

    @Before("@annotation(AuthorizeUser)")
    public void authorize(JoinPoint joinPoint) throws Throwable {
        //get the jwt cookie
        System.out.println("annotation");
        HttpServletRequest req = getRequest();

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("jwtbet")) {
                    String jwtbetCookieValue = cookie.getValue();
                    System.out.println(jwtbetCookieValue);

                    //decode thw jwt cookie and validate it
                    JwtUtil jwtUtil = new JwtUtil();
                    Integer user_id = jwtUtil.extractUserId(jwtbetCookieValue);
                    System.out.println("jwt validated");

                    if(user_id==null){
                        throw new CustomJwtBetException("Invalid jwtbet cookie value");
                    }
                    break;
                }
            }
        }
    }

    private HttpServletRequest getRequest() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return sra.getRequest();
    }
}