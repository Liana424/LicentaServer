package ubb.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ubb.licenta.entity.ImagineEveniment;


@Repository
public interface ImagineEvenimentRepository extends JpaRepository<ImagineEveniment, Integer> {
}
