package com.UserService;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Exception.UserNotFoundException;
import com.entity.AbstractUser;
import com.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	static
	UserRepository repo;
	
	public static AbstractUser addAbstractUser(AbstractUser c)
	{
		repo.save(c);
		return c;	
	}

	public static List<AbstractUser> getAbstractUsers() {
		List<AbstractUser> ls=repo.findAll();
		return ls;
	}

	public static AbstractUser getAbstractUserByString(String username) throws Throwable {
		Supplier s1= ()->new UserNotFoundException("AbsractUser Does not exist in the database");
		AbstractUser c=((UserRepository) repo.findByString(username)).
				 orElseThrow(s1);
		return c;
	}

	public static String deleteAbstractUserByString(String username) {
		
		repo.deleteByString(username);
		
		return "Deleted";
	}

	public static String deleteAbstractUser(AbstractUser c) {
		
		repo.delete(c);
		return "Deleted";
	}

	public static AbstractUser updateAbstractUser(AbstractUser c) throws Throwable {
		String usname=c.getUsername();
		Supplier s1= ()->new UserNotFoundException("username Does not exist in the database");
		AbstractUser c1=((UserRepository) repo.findByString(usname)).orElseThrow(s1);
		
		c1.setPassword(c.getPassword());
			c1.setMobileNumber(c.getMobileNumber());
			repo.save(c1);
			return c1;	
	}

	public static List<AbstractUser> addAbstractUsers(List<AbstractUser> ls) {
		repo.saveAll(ls);
		return ls;
	}

	public static AbstractUser getAbstractUserByPassword(String password) {
	    AbstractUser c=repo.getAbstractUserByPassword(password);
		return c;
	}
	
	public static List<AbstractUser> getAbstractUSerBymobilenumberSorted(String mobileNumber)
	{
		List<AbstractUser> lc=repo.getAbstractUSerBymobilenumberSorted(mobileNumber);
		return lc;
	}
	
	public static List<AbstractUser> getAbstractUserByemail(String email)
	{
		List<AbstractUser> lc=repo.getAbstractUserByemail(email);
		return lc;
	}
}
