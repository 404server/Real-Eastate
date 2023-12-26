package session.service;

import org.springframework.web.multipart.MultipartFile;

import session.model.UserAccount;
import session.model.UserProfile;

public interface UserService {

  void saveUser(UserAccount user, UserProfile profile);

  UserAccount findByUsername(String username);

  UserAccount getUserLogin();

  void saveImage(MultipartFile file, UserProfile profile) throws Exception;

  void editUserProfile(UserProfile profile);

  UserProfile getProfile(int idProfile);
}