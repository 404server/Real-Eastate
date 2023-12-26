package session.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import session.model.Apartments;

public interface UserHouseService {

  List<Apartments> listUserHouse();

  void postHouse(MultipartFile file, Apartments house) throws Exception;

  void editHouse(Apartments house);

  void activateHousePost(int id);

  void deactivateHousePost(int id);

  Apartments getHouseById(int id);

  void saveUploadPicture(MultipartFile file, Apartments house) throws Exception;
}