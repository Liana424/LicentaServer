package ubb.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ubb.licenta.entity.ImagineCazare;


@Repository
public interface ImagineCazareRepository extends JpaRepository<ImagineCazare, Integer> {
}
