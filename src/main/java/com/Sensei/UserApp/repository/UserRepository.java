package com.Sensei.UserApp.repository;

import com.Sensei.UserApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    public User findByUserName(String userName);
    public User findByUserNameIgnoreCase(String userName);
}
