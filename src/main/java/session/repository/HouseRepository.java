package session.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import session.model.Apartments;

import java.util.List;

public interface HouseRepository extends JpaRepository<Apartments, Integer> {

    @Query(value = "SELECT * FROM tb_house " +
            "WHERE type LIKE '%' || :keyword || '%'\n" +
            "   OR info LIKE '%' || :keyword || '%'\n" +
            "   OR year LIKE '%' || :keyword || '%';", nativeQuery = true)
    List<Apartments> searchHouse(@Param("keyword") String keyword);

    @Query(value = "SELECT * FROM tb_house "
            + "WHERE price >= :low AND price <= :high", nativeQuery = true)
    List<Apartments> searchHouseByPriceRange(@Param("low") int low, @Param("high") int high);

    @Query(value = "SELECT * FROM tb_house\n" +
            "WHERE (type LIKE '%' || :keyword || '%'\n" +
            "   OR info LIKE '%' || :keyword || '%'\n" +
            "   OR year LIKE '%' || :keyword || '%')\n" +
            "   AND price >= :low AND price <= :high;", nativeQuery = true)
    List<Apartments> searchHouseByKeywordAndPriceRange(@Param("keyword") String keyword, @Param("low") int low,
                                                     @Param("high") int high);

    @Query(value = "SELECT * FROM tb_house WHERE status = 'ACTIVE' LIMIT 3;", nativeQuery = true)
    List<Apartments> featuredHouses();
}