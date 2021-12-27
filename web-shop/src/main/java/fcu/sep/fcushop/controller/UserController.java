package fcu.sep.fcushop.controller;


import fcu.sep.fcushop.model.User;
import fcu.sep.fcushop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
  @Autowired
  UserService userManager;

  @GetMapping("/users")
  public List<User> getUsers() {
    System.out.println("-------------------------------------------");
    System.out.println( userManager.getUsers());
    System.out.println("-------------------------------------------");

    return userManager.getUsers();

  }


  @GetMapping("/users/{account}/{password}")
  public List<User> getUsers(@PathVariable("account") String account,@PathVariable("password") String password) {
    return userManager.getUsers(account,password);
  }
  @GetMapping("/login.html/users/{account}")
  public List<User> getUsers(@PathVariable("account") String account) {
    return userManager.getUsers(account);
  }
}