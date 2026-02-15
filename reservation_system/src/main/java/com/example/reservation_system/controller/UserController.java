package com.example.reservation_system.controller;

import com.example.reservation_system.repository.User;
import com.example.reservation_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> GetAllUsers() {
        return userService.GetAllUsers();
    }

    @PostMapping
    public User AddUser(@RequestBody User user) {
        return userService.AddUser(user);
    }

    //48 min
    @DeleteMapping(path = "{id}")
    public void DeleteUser(@PathVariable Long id) {
        userService.DeleteUser(id);
    }

    @PutMapping(path = "{id}")
    public void UpdateUser(
            @PathVariable Long id,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String name
    ) {
        userService.UpdateUser(id, email, name);
    }

}
