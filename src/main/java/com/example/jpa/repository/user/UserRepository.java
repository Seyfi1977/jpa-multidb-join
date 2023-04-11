package com.example.jpa.repository.user;

import com.example.jpa.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findByCusipNumberIn(List<String> cusipNumbers);
}
