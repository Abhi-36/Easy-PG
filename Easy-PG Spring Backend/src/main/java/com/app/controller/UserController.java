package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Propertydto;
import com.app.dto.UserDto;
import com.app.pojos.User;
import com.app.service.UserService;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
	@RequestMapping(method = RequestMethod.OPTIONS)
	public ResponseEntity<?> handleOptions() {
	    return ResponseEntity.ok().build();
	}

	@Autowired
	public UserService userservice;
	
	public UserController() {
		System.out.println("UserControllerCalled");
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        try {
            UserDto userDto = userservice.getById(id);
            if (userDto != null) {
                return ResponseEntity.ok(userDto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Handle exception and return appropriate response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
	@PutMapping("/edit")
	public User updateUser(@RequestBody UserDto User)
	{
		return userservice.updateUser(User);		
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody UserDto User) {
	
		return ResponseEntity.ok(userservice.addUser(User));
	}
	
	@GetMapping("/showcart/{id}")
	public List<Propertydto> getPrpertiesById(@PathVariable Long id){
		return userservice.findById(id);
	}
	

}

