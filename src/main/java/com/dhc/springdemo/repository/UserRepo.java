package com.dhc.springdemo.repository;

import com.dhc.springdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by reed on 2017/4/27.
 */
public interface UserRepo extends JpaRepository<User,Serializable>{

}
