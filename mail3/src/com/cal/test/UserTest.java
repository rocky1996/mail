package com.cal.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cal.user.User;
import com.cal.user.dao.UserDao;
import com.cal.user.dao.impl.UserDaoImpl;

public class UserTest extends UserDaoImpl {
	private UserDao ud = new UserDaoImpl();
	@Test
	public void testAddUser() {
		User u = new User();
		u.setEmail("12346");
		u.setTitle("gvhj");
		u.setEmail("frght");
		ud.addUser(u);
	}

	@Test
	public void testTosuccess() {
		ud.Tosuccess("2791752775@qq.com", "222", "222");
	}

}
 