package com.gridbetjavaa.gridbetjavaa.service;

import com.gridbetjavaa.gridbetjavaa.model.User;
import com.gridbetjavaa.gridbetjavaa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Long newUser(User user){
        //check if user exists
        Long user_id = getEmailId(user.getEmail());
        System.out.println("userid " + user_id + " " + user.getEmail());
        if(user_id!=0){
            return 0L;
        }
        try {
            User newuser = userRepository.save(new User(user.getEmail(),user.getPassword()));
            return newuser.getId();
        } catch (Exception e) {
            return 0L;
        }
    }

    public Long getEmailId(String email){
        try {
            return userRepository.findByEmail(email).getId();
        } catch (Exception e) {
            System.out.println(e);
            return 0L;
        }
    }

    public Long userLogin(User user){
        return 0L;
    }
}
