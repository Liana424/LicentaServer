package ubb.licenta.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ubb.licenta.entity.Room;


import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    // se foloseste : ca sa legam valoarea trimisa ca parametru de query-ul scris
   /* @Query(value = "SELECT ca FROM Room ca WHERE ca.type=:type")
    List<Room> findAllByType(String type); */

    @Query(value = "SELECT r FROM Room r WHERE r.accommodation.name=:accommodationname")
    List<Room> findAllByAccommodation(String accommodationname);
}
