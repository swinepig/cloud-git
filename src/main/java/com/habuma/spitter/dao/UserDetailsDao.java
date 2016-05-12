package com.habuma.spitter.dao;

import com.habuma.spitter.entity.UserAttempts;


/***
 * spring security使用
 * @author zhuxin
 *
 */
public interface UserDetailsDao {

	void updateFailAttempts(String username);

	void resetFailAttempts(String username);

	UserAttempts getUserAttempts(String username);
}
