package session.service;

import java.util.List;

import session.model.Apartments;

public interface ApartmentsService {

  Apartments getHouseById(int id);

  List<Apartments> listHouses();

  List<Apartments> searchApartments(String keyword);

  List<Apartments> searchHouseByPriceRange(int low, int high);

  List<Apartments> searchHouseByKeywordAndPriceRange(String keyword, int low, int high);

  List<Apartments> featuredHouses();
}