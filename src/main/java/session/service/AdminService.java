package session.service;

import java.util.List;

import session.model.Apartments;
import session.model.UserAccount;
import session.model.UserProfile;

public interface AdminService {

  void editUser(UserProfile profile);

  void markAsAdmin(int idUser);

  UserProfile getProfileById(int idCar);

  List<UserAccount> listUser();

  List<UserAccount> listAdmin();

  List<Apartments> listHouses();

}