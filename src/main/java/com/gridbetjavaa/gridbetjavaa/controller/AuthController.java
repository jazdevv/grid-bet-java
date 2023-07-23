package com.gridbetjavaa.gridbetjavaa.controller;

import com.gridbetjavaa.gridbetjavaa.model.User;
import com.gridbetjavaa.gridbetjavaa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody User user){
        //create the user
        Long user_id = userService.newUser(user);
        System.out.println(user_id);
        //if returned id = 0, email was taken and user cant be created
        if(user_id!=0){
            return ResponseEntity.ok()
                    .body("succes");
        }else{
            return ResponseEntity.ok()
                    .body("fail");
        }
    }

    @PostMapping("/login")
    public Boolean login(@RequestBody User user){
        return true;
    }

    private HttpHeaders createAuthCookie(Long id){
        //Create the cookie
        ResponseCookie cookie = ResponseCookie.from("id",id.toString()).build();
        // Add the cookie to the response headers
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(HttpHeaders.SET_COOKIE, cookie.toString());
        return responseHeaders;
    }
}
