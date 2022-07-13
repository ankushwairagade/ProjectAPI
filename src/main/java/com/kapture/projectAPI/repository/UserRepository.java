package com.kapture.projectAPI.repository;

import com.kapture.projectAPI.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByuserId(long userId);

    User findByEmail(String name);
}
