package com.heggi.learnBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.heggi.learnBackend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
