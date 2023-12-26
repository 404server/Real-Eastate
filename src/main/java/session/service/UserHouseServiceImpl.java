package session.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import session.model.*;
import session.model.Apartments;
import session.repository.HousePictureRepository;
import session.repository.HouseRepository;


@Service
public class UserHouseServiceImpl implements UserHouseService {

  @Autowired
  private UserService userService;

  @Autowired
  private HouseRepository houseRepo;

  @Autowired
  private HousePictureRepository housePictureRepo;

  @Override
  public List<Apartments> listUserHouse() {
    List<Apartments> listUserHouse = houseRepo.findAll();
    UserAccount user = userService.getUserLogin();

    listUserHouse.removeIf(house -> house.getUser() != user);

    return listUserHouse;
  }

  @Override
  public void postHouse(MultipartFile file, Apartments house) throws Exception {
    UserAccount user = userService.getUserLogin();
    HousePicture picture = new HousePicture();

    picture.setFileName(file.getOriginalFilename());
    picture.setFileType(file.getContentType());
    picture.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
    picture.setHouse(house);

    house.setHousePicture(picture);
    house.setStatus("ACTIVE");
    house.setUser(user);

    houseRepo.save(house);
  }

  @Override
  public void editHouse(Apartments house) {
    Apartments edited = houseRepo.findById(house.getIdHouse()).get();

    edited.setType(house.getType());
    edited.setInfo(house.getInfo());
    edited.setYear(house.getYear());
    edited.setPrice(house.getPrice());

    houseRepo.save(edited);
  }

  @Override
  public void activateHousePost(int id) {
    Apartments edited = houseRepo.findById(id).get();

    edited.setStatus("ACTIVE");

    houseRepo.save(edited);
  }

  @Override
  public void deactivateHousePost(int id) {
    Apartments edited = houseRepo.findById(id).get();

    edited.setStatus("DEACTIVE");

    houseRepo.save(edited);
  }

  @Override
  public Apartments getHouseById(int id) {
      return houseRepo.findById(id).get();
  }

  @Override
  public void saveUploadPicture(MultipartFile file, Apartments house) throws Exception {
    try {
      HousePicture picture = house.getHousePicture();

      picture.setFileName(file.getOriginalFilename());
      picture.setFileType(file.getContentType());
      picture.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
      picture.setHouse(house);

      housePictureRepo.save(picture);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}