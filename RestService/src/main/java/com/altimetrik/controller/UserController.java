package com.altimetrik.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.altimetrik.dao.UserDaoService;
import com.altimetrik.model.User;
import com.altimetrik.model.UserNotPresentException;

@RestController
public class UserController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	UserDaoService dao;

	@GetMapping(path = "/hello1")
	public String helloUser() {
		return "Hello world :)";
	}

	@GetMapping(path = "hello/i18")
	public String helloUserInternatlixation(@RequestHeader(name = "Accept-Language", required = false)
	Locale locale) {
		return messageSource.getMessage("good.morning.neha", null, LocaleContextHolder.getLocale());

	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloBean() {
		return new HelloWorldBean("Hello world :)");
	}

	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloBeanPathVariable(@PathVariable("name") String pathvariable) {
		return new HelloWorldBean("Hello world :)by path variable " + pathvariable);
	}

	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		return dao.getAllUser();
	}

	@GetMapping(path = "/users/{id}")
	public User getUserById(@PathVariable("id") int pk) {
		User presentUser = dao.getOneUser(pk);

		/*
		 * Resource<User> res=new Resource<User>(presentUser); ControllerLinkBuilder
		 * linkTo=
		 * ControllerLinkBuilder.linkTo(methodOn(this.getClass(),getAllUsers()));
		 * 
		 * res.add(linkTo.withRel(" By Neha "));
		 */

		if (presentUser == null) {
			throw new UserNotPresentException("id is not present : " + pk);
		}
		return dao.getOneUser(pk);
	}

	@PostMapping(path = "/user")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User savedUser = dao.addNewUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
		// return dao.addNewUser(user);

	}

	@DeleteMapping(path = "/user/{id}")
	public void deleteUser(@PathVariable("id") int pk) {
		User user = dao.deleteSpecificUser(pk);
		System.out.println("user is deleted successfullyy..");

	}

}
