package ubb.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ubb.licenta.entity.ImagineCamera;

@Repository
public interface ImagineCameraRepository extends JpaRepository<ImagineCamera, Integer> {

}
