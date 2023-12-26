package session.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import session.model.UserAccount;

public interface UserRepository extends JpaRepository<UserAccount, Integer> {

  public UserAccount findByUsername(String username);

}