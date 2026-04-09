package com.voidis.sea_orange_pre.repository;

import com.voidis.sea_orange_pre.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
