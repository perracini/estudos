package br.com.rafa.estudo2.auth.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafa.estudo2.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	 User findByUsername(String username);
}
