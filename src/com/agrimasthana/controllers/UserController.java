package com.agrimasthana.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agrimasthana.dal.UserService;
import com.agrimasthana.model.User;

@RestController
@RequestMapping("/user/")
public class UserController {
	UserService userService= new UserService();
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getUser(@PathVariable int id) {
		User user=userService.getUser(id);
		return user;
	}
	
	@RequestMapping(method = RequestMethod.GET,headers="Accept=application/json")
	public List<User> getAllUsers(){
	List<User> users = userService.getAllUsers();
	return users;
	}
	
	@RequestMapping(method = RequestMethod.POST,consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody User u){
	userService.createUser(u);
	}
	
	@RequestMapping(method = RequestMethod.PUT,consumes="application/json")
	@ResponseStatus(HttpStatus.OK)
	public void updateUser(@RequestBody User u){
		userService.updateUser(u);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE,consumes="application/json")
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable int id){
		userService.deleteUser(id);
	}

}
