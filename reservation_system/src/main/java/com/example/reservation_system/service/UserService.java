package com.example.reservation_system.service;

import com.example.reservation_system.repository.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Component
public class UserService {
    @GetMapping
    public List<User> GetAllUsers() {
        return List.of(
                new User(1L, "Maga", "Maga@mail.ru", LocalDate.of(2007,11,21),34),
                new User(2L, "Musa", "Musa@mail.ru", LocalDate.of(2007,2,22),31),
                new User(3L, "Kъuma", "Kumazavr@mail.ru", LocalDate.of(2007,1,1),22)
        );
    }
}
