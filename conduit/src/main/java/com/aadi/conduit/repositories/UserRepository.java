package com.aadi.conduit.repositories;

import com.aadi.conduit.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  UserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByUserName(@Param("username") String username);

}
