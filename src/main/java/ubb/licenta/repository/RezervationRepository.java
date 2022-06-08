package ubb.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ubb.licenta.entity.Rezervation;


@Repository
public interface RezervationRepository extends JpaRepository<Rezervation, Integer> {
}

