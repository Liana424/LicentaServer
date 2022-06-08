package ubb.licenta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ubb.licenta.entity.ImagineCamera;

import ubb.licenta.repository.ImagineCameraRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImagineCameraService {
    private final ImagineCameraRepository imagineCameraRepository;

    public Integer insert(ImagineCamera imagineCamera) {
        ImagineCamera savedImagineCamera = imagineCameraRepository.save(imagineCamera);

        return savedImagineCamera.getId();
    }

    public ImagineCamera findById(Integer id) {
        // findById returneaza un Optional, de aceea avem Optional aici
        Optional<ImagineCamera> imagineCamera = imagineCameraRepository.findById(id);

        // e bine sa verificam ca exista si sa prindem exceptiile care pot sa apara daca cumva ii empty
        if (imagineCamera.isEmpty()) {
            throw new EntityNotFoundException("Imaginea cu id = " + id + " nu a fost gasita!");
        }

        // cu .get() returnam obiectul "ascuns" in Optional
        return imagineCamera.get();
    }

    public List<ImagineCamera> findAll() {
        // findById returneaza un Optional, de aceea avem Optional aici
        return imagineCameraRepository.findAll();

    }

    public void delete(Integer id) {
        imagineCameraRepository.deleteById(id);
    }

    public ImagineCamera update(ImagineCamera imagineCamera) {
        Optional<ImagineCamera> oldImagineCamera = imagineCameraRepository.findById(imagineCamera.getId());

        if (oldImagineCamera.isEmpty()) {
            return null;
        }

        return imagineCameraRepository.save(imagineCamera);
    }
}
