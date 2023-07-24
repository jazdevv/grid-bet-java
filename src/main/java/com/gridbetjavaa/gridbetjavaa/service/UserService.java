package com.gridbetjavaa.gridbetjavaa.service;

import com.gridbetjavaa.gridbetjavaa.model.User;
import com.gridbetjavaa.gridbetjavaa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

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
        //get the user
        User user_id = userRepository.findByEmail(user.getEmail());
        System.out.println(user_id.getPassword() + " " + user.getPassword());
        //compare passwords
        if(user_id.getPassword().equals(user.getPassword())){
            System.out.println("logged");
            return user_id.getId();
        }else{
            System.out.println("passwords don`t match");
            return 0L;
        }
    }

    public void incrementUserCredit(Long userid, Float amount){
        User user = userRepository.findById(userid).orElse(null);
        if(user!=null){
            Float incrementedAmount = user.getCredit() + amount;
            user.setCredit(incrementedAmount);
            userRepository.save(user);
        }
    }

    public void decreaseUserCredit(Long userid, Float amount){
        User user = userRepository.findById(userid).orElse(null);
        if(user!=null){
            Float incrementedAmount = user.getCredit() - amount;
            user.setCredit(incrementedAmount);
            userRepository.save(user);
        }
    }
}
