package ubb.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ubb.licenta.entity.Country;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

    // se foloseste : ca sa legam valoarea trimisa ca parametru de query-ul scris
    @Query(value = "SELECT t FROM Country t WHERE t.name=:name")
    Optional<Country> findByName(String name);
}