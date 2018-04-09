package by.bsuir.nesenchuk.dao;

import by.bsuir.nesenchuk.entity.User;

public interface UserDAO {
    User createUser(User user);
    User getUserById(Long id);
    User getUserByEmail(String email);
}
