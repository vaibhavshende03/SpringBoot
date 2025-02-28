package com.vs.main.services;

import com.vs.main.entities.User;

public interface UserServices {
	
	public boolean regiteruser(User user);
	public User loginuser(String email,String password);
}
