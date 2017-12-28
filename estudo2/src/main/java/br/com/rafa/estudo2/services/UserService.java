package br.com.rafa.estudo2.services;

import br.com.rafa.estudo2.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
