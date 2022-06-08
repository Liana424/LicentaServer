package ubb.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ubb.licenta.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // se foloseste : ca sa legam valoarea trimisa ca parametru de query-ul scris
    @Query(value = "SELECT u FROM User u WHERE u.username=:username")
    Optional<User> findByUsername(String username);

}
