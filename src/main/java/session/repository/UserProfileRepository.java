package session.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import session.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

}