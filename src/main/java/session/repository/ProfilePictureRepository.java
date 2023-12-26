package session.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import session.model.ProfilePicture;

public interface ProfilePictureRepository extends JpaRepository<ProfilePicture, Integer> {

}