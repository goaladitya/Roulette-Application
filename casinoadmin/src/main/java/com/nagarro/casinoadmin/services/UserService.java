package com.nagarro.casinoadmin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.casinoadmin.controllers.Search;
import com.nagarro.casinoadmin.models.User;
import com.nagarro.casinoadmin.repositories.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public String addNewUser(User user) {
		userDao.save(user);
		return "user added";
	}
	
	public List<User> getAllUsers() {
		return (List<User>) userDao.findAll();
	}

	public List<User> find(Search search) {
//		String name=(search.getName()!=null)?search.getName():"";
//		Long contact=(search.getContact()!=null)?search.getContact():9;
//		String email=(search.getEmail()!=null)?search.getName():"";
		return userDao.findByNameOrContactOrEmail(search.getName(),search.getContact(),search.getEmail());
	}

	public User getUserById(Long id) {
		return userDao.findOne(id);
	}

	public List<User> recharge(Long id, Long balance) {
		User user = userDao.findOne(id);
//		Long currBalance = user.getBalance();
		user.setBalance(user.getBalance() + balance);
		userDao.save(user);
		return (List<User>) userDao.findAll();
	}

	public User block_amount(Long id, Long block_amt) {
		User user = userDao.findOne(id);
		if(user.getBalance() - block_amt <0)
			return null;
		user.setBalance(user.getBalance() - block_amt);		
		user.setBlocked_amount(block_amt);
		userDao.save(user);
		return user;
	}

	public User winning_amount(Long id, Long winning_amt) {
		User user = userDao.findOne(id);
		user.setBalance(user.getBalance()+winning_amt);
		user.setBlocked_amount(new Long(0));
		userDao.save(user);
		return user;
	}


}
