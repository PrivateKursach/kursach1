package by.bsuir.nesenchuk.service;

import by.bsuir.nesenchuk.entity.User;

public interface UserService {
    User login(String email, String password);
    User createUser(User user);
}
