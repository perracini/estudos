package br.com.rafa.estudo2.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.rafa.estudo2.auth.repository.RoleRepository;
import br.com.rafa.estudo2.auth.repository.UserRepository;
import br.com.rafa.estudo2.models.Role;
import br.com.rafa.estudo2.models.User;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    	
    	Set<Role> roles = new HashSet<Role>(roleRepository.findAll());
    	
    	for (Role role :roles) {
    	    if (role.getPermission().contains("USER")){
    	    	if (!user.getRole().contains(role)){
    	    		 user.getRole().add(role);
    	    	}
    	    }
    	}

        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
