package com.gridbetjavaa.gridbetjavaa.controller;

import com.gridbetjavaa.gridbetjavaa.model.User;
import com.gridbetjavaa.gridbetjavaa.service.UserService;
import com.gridbetjavaa.gridbetjavaa.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/auth")
public class AuthController {

    private JwtUtil jwtUtil;
    @Autowired
    UserService userService;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = new JwtUtil();
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody User user){
        //create the user
        Long user_id = userService.newUser(user);

        //if returned id = 0, email was taken and user cant be created
        if(user_id!=0){
            //generate cookies
            String token = this.createAuthCookie(user_id);
            //Create the cookie
            ResponseCookie cookie = ResponseCookie.from("jwtbet",token).build();
            // Add the cookie to the response headers
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add(HttpHeaders.SET_COOKIE, cookie.toString());

            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(token);
        }else{
            return ResponseEntity.ok()
                    .body("fail");
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user){
        //login user
        Long user_id = userService.userLogin(user);
        System.out.println(user_id);
        //if returned id = 0, email was taken and user cant be created
        if(user_id!=0){
            //generate cookies
            String token = this.createAuthCookie(user_id);
            //Create the cookie
            ResponseCookie cookie = ResponseCookie.from("jwtbet",token).build();
            // Add the cookie to the response headers
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add(HttpHeaders.SET_COOKIE, cookie.toString());
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(token);
        }else{
            return ResponseEntity.ok()
                    .body("fail");
        }
    }

    @GetMapping("/mycredit")
    public Float getMyCredit(String jwtToken){
        Long userid = jwtUtil.authorize(jwtToken);
        return userService.getUserCredit(userid);
    }


    private String createAuthCookie(Long id){
        //Generate JWT
        JwtUtil jwtUtil = new JwtUtil();
        String token = jwtUtil.generateToken(id);
        System.out.println("jwt " + token);
        return token;
    }


}
