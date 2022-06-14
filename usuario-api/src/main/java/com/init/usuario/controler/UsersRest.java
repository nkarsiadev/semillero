package com.init.usuario.controler;

import com.init.usuario.config.exception.UserException;
import com.init.usuario.entitys.User;

import java.util.List;

import com.init.usuario.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("users")
public class UsersRest {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		try{
			return ResponseEntity.ok(userService.getUsers());
		}catch (UserException userRxception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}catch (Exception exception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@RequestMapping(value = "{userId}")
	public ResponseEntity<User> getUSerById(@PathVariable("userId") Long userId){
		try{
			return ResponseEntity.ok(userService.getUSerById(userId));
		}catch (UserException userRxception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}catch (Exception exception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@PostMapping 
	public ResponseEntity<User> createUser(@RequestBody User user){
		try{
			return ResponseEntity.ok(userService.createUser(user));
		}catch (UserException userRxception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}catch (Exception exception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@DeleteMapping(value = "{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId){
		try{
			return ResponseEntity.ok(userService.deleteUser(userId));
		}catch (UserException userRxception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}catch (Exception exception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user){
		try{
			return ResponseEntity.ok(userService.updateUser(user));
		}catch (UserException userRxception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}catch (Exception exception){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
}
