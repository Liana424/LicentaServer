package ubb.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ubb.licenta.entity.Event;


import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{
    // se foloseste : ca sa legam valoarea trimisa ca parametru de query-ul scris
       /* @Query(value = "SELECT e FROM Event e WHERE e.name=:name")
        Optional<Event> findByName(String name);*/
        @Query(value = "SELECT e FROM Event e WHERE e.city.name=:cityname")
        List<Event> findAllByCity(String cityname);
}
