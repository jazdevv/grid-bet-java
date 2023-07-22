package com.gridbetjavaa.gridbetjavaa.repository;

import com.gridbetjavaa.gridbetjavaa.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    public User findByEmail(String email);
    public User findUserById(Long id);
}
