package com.learnspring.webservices.restfulservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int count =2;
	static {
		users.add(new User(1,"shivam", new Date()));
		users.add(new User(2,"mayank", new Date()));	
	}
	public List findAll() {
		return users;
	}
	public User save(User user) {
		if(user.getId()==0) {
			user.setId(++count);
		}
		users.add(user);
		return user;
	}
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	public User deleteById(int id) {
		Iterator<User> it = users.iterator();
		while(it.hasNext()) {
			User user = it.next();
			if(user.getId()==id) {
				it.remove();
				return user;
			}
		}
		return null;
	}

}
