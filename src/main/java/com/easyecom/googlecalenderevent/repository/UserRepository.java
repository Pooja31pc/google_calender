package com.easyecom.googlecalenderevent.repository;

import com.easyecom.googlecalenderevent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select pe from User pe where pe.email=:email")
    Optional<User> findByEmailForEvent(@Param("email") String email);

}
