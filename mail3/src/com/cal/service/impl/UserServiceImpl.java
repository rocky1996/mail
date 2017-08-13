package com.cal.service.impl;

import com.cal.service.UserService;
import com.cal.user.User;
import com.cal.user.dao.UserDao;
import com.cal.user.dao.impl.UserDaoImpl;

public class UserServiceImpl implements UserService {
	private UserDao ud = new UserDaoImpl();
	@Override
	public void addUser(User u) {
		ud.addUser(u);
	}

	@Override
	public void Tosuccess(String email, String title, String essay) {
		ud.Tosuccess(email, title, essay);
	}

}
