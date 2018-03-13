package com.retailx.spring.dao;

import com.retailx.entity.User;

import com.retailx.entity.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("commonDao")
@Transactional(propagation=Propagation.REQUIRED)
public class CommonDaoImpl extends AbstractDao implements CommonDao {

    public User getUserByLoginID(final String loginID) {
        final String queryString = "select u from User u where u.loginID=:loginID";
        Query query = getSession().createQuery(queryString);
        query.setString("loginID", loginID);
        return (User) query.uniqueResult();
    }

}
