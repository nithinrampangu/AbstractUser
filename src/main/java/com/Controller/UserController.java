package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AbstractUser;
import com.UserService.UserService;

//@Controller
@RestController
@RequestMapping(path="/api")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@RequestMapping("/hello")
	//@ResponseBody
	public String hello()
	{
		return "Welcome to Spring MVC";
	}
	
	@PostMapping("/addAbstractUser")
	public ResponseEntity<AbstractUser> addAbstractUser(@RequestBody AbstractUser c)
	{
		AbstractUser c2;
				c2=UserService.addAbstractUser(c);
		ResponseEntity re=new ResponseEntity<AbstractUser>(c2,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getAbstractUsers")
	public ResponseEntity<List<AbstractUser>> getAbstractUsers()
	{
		List<AbstractUser> lc1=UserService.getAbstractUsers();
		ResponseEntity re=new ResponseEntity<List<AbstractUser>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getAbstractUser/{username}")
	public ResponseEntity<AbstractUser> getAbstractUserByString(@PathVariable String username) throws Throwable
	{
		AbstractUser c1=UserService.getAbstractUserByString(username);
		
		ResponseEntity re=new ResponseEntity<AbstractUser>(c1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addAbstractUsers")
	public ResponseEntity<List<AbstractUser>> addAbstractUsers(@RequestBody List<AbstractUser> ls)
	{
		List<AbstractUser> le=UserService.addAbstractUsers(ls);
		
		ResponseEntity re=new ResponseEntity<List<AbstractUser>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateAbstractUser")
	public ResponseEntity<AbstractUser> updateAbstractUser(@RequestBody AbstractUser e) throws Throwable
	{
		AbstractUser e1=UserService.updateAbstractUser(e);
		
		ResponseEntity re=new ResponseEntity<AbstractUser>(e1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteAbstractUser")
	public ResponseEntity<String> deleteAbstractUser(@RequestBody AbstractUser e)
	{
		UserService.deleteAbstractUser(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteAbstractUser/{uname}")
	public ResponseEntity<String> deleteAbstractUserByString(@PathVariable String uname)
	{
		UserService.deleteAbstractUserByString(uname);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getAUpassword/{password}")
	public ResponseEntity<AbstractUser> getAbstractUserByPassword(@PathVariable String password) 
	{
   AbstractUser c=UserService.getAbstractUserByPassword(password);
		ResponseEntity re=new ResponseEntity<AbstractUser>(c,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getAUmobileNumber/{mobileNumber}")
	public ResponseEntity<List<AbstractUser>> findBymobileNumberSorted(@PathVariable String mobileNumber) 
	{
		List<AbstractUser> lc=UserService.getAbstractUSerBymobilenumberSorted(mobileNumber);
		ResponseEntity re=new ResponseEntity<List<AbstractUser>>(lc,HttpStatus.OK);
		return re;
	}
	@GetMapping("/getAUemail/{email}")
	public ResponseEntity<AbstractUser> getAbstractUserByemail(@PathVariable String email) 
	{
   List<AbstractUser> c=UserService.getAbstractUserByemail(email);
		ResponseEntity re=new ResponseEntity<AbstractUser>((AbstractUser) c,HttpStatus.OK);
		return re;
	}
}
