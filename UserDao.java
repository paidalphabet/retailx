package com.retailx.spring.dao;


import com.retailx.entity.User;

public interface UserDao extends BaseDao {

	public User getUserByLoginID(final String loginID);
}
