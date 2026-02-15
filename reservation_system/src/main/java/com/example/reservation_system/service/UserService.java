package com.example.reservation_system.service;

import com.example.reservation_system.repository.User;
import com.example.reservation_system.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> GetAllUsers() {
        return userRepository.findAll();
    }


    public User AddUser(User user) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            throw new RuntimeException("User with email " + user.getEmail() + " already exists");
        }
        user.setAge(Period.between(user.getBirth(), LocalDate.now()).getYears());
        return userRepository.save(user);
    }

    public void DeleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User with id " + id + " does not exist");
        }
        userRepository.deleteById(id);

    }
}
