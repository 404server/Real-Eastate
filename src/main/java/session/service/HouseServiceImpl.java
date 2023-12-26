package session.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import session.model.Apartments;
import session.repository.HouseRepository;

@Service
public class HouseServiceImpl implements ApartmentsService {

  @Autowired
  private HouseRepository houseRepo;

  @Override
  public List<Apartments> listHouses() {
    List<Apartments> listHouse = houseRepo.findAll();

    listHouse.removeIf(car -> car.getStatus().equals("DEACTIVE"));

    return listHouse;
  }

  @Override
  public List<Apartments> searchApartments(String keyword) {
    List<Apartments> houses = houseRepo.searchHouse(keyword);

    houses.removeIf(home -> home.getStatus().equals("DEACTIVE"));

    return houses;
  }

  @Override
  public List<Apartments> searchHouseByPriceRange(int low, int high) {
    List<Apartments> houses = houseRepo.searchHouseByPriceRange(low, high);
    System.out.println(low + " " + high);

    houses.removeIf(home -> home.getStatus().equals("DEACTIVE"));

    return houses;
  }

  @Override
  public Apartments getHouseById(int id) {
      return houseRepo.findById(id).get();
  }

  @Override
  public List<Apartments> searchHouseByKeywordAndPriceRange(String keyword, int low, int high) {
    List<Apartments> houses = houseRepo.searchHouseByKeywordAndPriceRange(keyword, low, high);

    houses.removeIf(home -> home.getStatus().equals("DEACTIVE"));

    return houses;
  }

  @Override
  public List<Apartments> featuredHouses() {
      return houseRepo.featuredHouses();
  }

}