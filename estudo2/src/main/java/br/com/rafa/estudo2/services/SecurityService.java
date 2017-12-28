package br.com.rafa.estudo2.services;

public interface SecurityService {
    String findLoggedInUsername();
    void autologin(String username, String password);
}
