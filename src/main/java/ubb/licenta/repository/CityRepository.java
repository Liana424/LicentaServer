package ubb.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ubb.licenta.entity.City;
import ubb.licenta.entity.Country;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    // se foloseste : ca sa legam valoarea trimisa ca parametru de query-ul scris
    @Query(value = "SELECT l FROM City l WHERE l.name=:name")
    Optional<City> findByName(String name);

    @Query(value = "SELECT c FROM City c WHERE c.country.name=:countryname")
    List<City> findAllByCountry(String countryname);
}
