package com.dhc.springdemo.service.impl;

import com.dhc.springdemo.entity.User;
import com.dhc.springdemo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by reed on 2017/4/27.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(User user) {
        em.persist(user);
    }
}
