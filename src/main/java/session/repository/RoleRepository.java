package session.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import session.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

  public Role findByRole(String role);
}