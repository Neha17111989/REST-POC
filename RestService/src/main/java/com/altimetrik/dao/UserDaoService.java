package com.altimetrik.dao;

import java.util.*;

import org.springframework.stereotype.Component;

import com.altimetrik.model.User;
import com.altimetrik.model.UserNotPresentException;

@Component
public class UserDaoService {

	public static List<User> list = new ArrayList();
	static {
		list.add(new User(1, "neha", new Date()));
		list.add(new User(2, "ajit", new Date()));
		list.add(new User(3, "nitin", new Date()));
	}
	static int count = 3;

	public List<User> getAllUser() {
		return list;
	}

	public User getOneUser(int pk) {
		if (list.size() < pk) {
			throw new UserNotPresentException("This Id " + pk + "not available..");
		}
		User user = list.get(pk);
		if (user == null) {
			throw new UserNotPresentException("This Id " + pk + "not available..");
		}
		return user;
	}

	public User addNewUser(User user) {
		if (user.getId() > 0) {
			System.out.println("given id" + user.getId());
			user.setId(++count);
		}
		user.setName(user.getName());
		user.setBirthDate(new Date());
		list.add(user);
		return user;
	}

	public User deleteSpecificUser(int pk) {
		Iterator<User> itr = list.iterator();
		while (itr.hasNext()) {
			User user= itr.next();
			if (user.getId() == pk) {
				itr.remove();
			}
		}
		return null;
	}

	
	
	

}
