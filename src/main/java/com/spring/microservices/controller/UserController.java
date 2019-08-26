package com.spring.microservices.controller;

import java.util.List;

import com.spring.microservices.model.User;
import com.spring.microservices.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class UserController {
  @Autowired
  public UserRepository repo;

  @PostMapping("/create")
  public User createUser(@RequestBody User body) {
    User user = new User(
      body.getEmail(), 
      body.getUsername(), 
      body.getPassword()
    );
    return repo.save(user);
  }

  @GetMapping("/user/{id}")
  public User getUser(@PathVariable("id") Long id) {
    User user = repo.findById(id)
                    .get();
    return user;
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    return repo.findAll();
  }

  @PutMapping("/user/{id}")
  public User editUser(@RequestBody User body, @PathVariable("id") Long id) {
    User user = repo.findById(id)
                    .get();
    if (body.getEmail() != null) {
      user.setEmail(body.getEmail());
    }
    if (body.getPassword() != null) {
      user.setPassword(body.getPassword());
    }
    
    return repo.save(user);
  }

  @DeleteMapping("/user/{id}")
  public String deleteUser(@PathVariable("id") Long id) {
    repo.deleteById(id);
    return "User deleted";
  }
}
