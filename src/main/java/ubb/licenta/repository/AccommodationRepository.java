package ubb.licenta.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ubb.licenta.entity.Accommodation;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Integer> {
    // se foloseste : ca sa legam valoarea trimisa ca parametru de query-ul scris
    @Query(value = "SELECT c FROM Accommodation c WHERE c.name=:name")
    Optional<Accommodation> findByName(String name);

    @Query(value = "SELECT a FROM Accommodation a WHERE a.city.name=:cityname")
    List<Accommodation> findAllByCity(String cityname);


}
