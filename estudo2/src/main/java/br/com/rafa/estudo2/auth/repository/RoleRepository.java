package br.com.rafa.estudo2.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafa.estudo2.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
}
