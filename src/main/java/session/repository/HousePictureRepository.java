package session.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import session.model.HousePicture;

public interface HousePictureRepository extends JpaRepository<HousePicture, Integer> {

}
