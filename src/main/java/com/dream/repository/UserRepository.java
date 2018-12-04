package com.dream.repository;

import com.dream.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Created by ning on 2017/9/17.
 */

@Transactional
@Repository
public class UserRepository {
	
    @PersistenceContext
    private EntityManager entityManagerFactory;

    @Transactional
    public User findUser(){
        return  entityManagerFactory.find(User.class, 12);
    }
}
