package ubb.licenta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ubb.licenta.entity.ImagineEveniment;

import ubb.licenta.repository.ImagineEvenimentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImagineEvenimentService {

        private final ImagineEvenimentRepository imagineEvenimentRepository;

        public Integer insert(ImagineEveniment imagineEveniment) {
            ImagineEveniment savedImagineEveniment = imagineEvenimentRepository.save(imagineEveniment);

            return savedImagineEveniment.getId();
        }

        public ImagineEveniment findById(Integer id) {
            // findById returneaza un Optional, de aceea avem Optional aici
            Optional<ImagineEveniment> imagineEveniment = imagineEvenimentRepository.findById(id);

            // e bine sa verificam ca exista si sa prindem exceptiile care pot sa apara daca cumva ii empty
            if (imagineEveniment.isEmpty()) {
                throw new EntityNotFoundException("Imaginea cu id = " + id + " nu a fost gasita!");
            }

            // cu .get() returnam obiectul "ascuns" in Optional
            return imagineEveniment.get();
        }

        public List<ImagineEveniment> findAll() {
            // findById returneaza un Optional, de aceea avem Optional aici
            return imagineEvenimentRepository.findAll();

        }

        public void delete(Integer id) {
            imagineEvenimentRepository.deleteById(id);
        }

        public ImagineEveniment update(ImagineEveniment imagineEveniment) {
            Optional<ImagineEveniment> oldImagineEveniment = imagineEvenimentRepository.findById(imagineEveniment.getId());

            if (oldImagineEveniment.isEmpty()) {
                return null;
            }

            return imagineEvenimentRepository.save(imagineEveniment);
        }

    }
