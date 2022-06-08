package ubb.licenta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ubb.licenta.entity.ImagineCazare;

import ubb.licenta.repository.ImagineCazareRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImagineCazareService {

        private final ImagineCazareRepository imagineCazareRepository;

        public Integer insert(ImagineCazare imagineCazare) {
            ImagineCazare savedImagineCazare = imagineCazareRepository.save(imagineCazare);

            return savedImagineCazare.getId();
        }

        public ImagineCazare findById(Integer id) {
            // findById returneaza un Optional, de aceea avem Optional aici
            Optional<ImagineCazare> imagineCazare = imagineCazareRepository.findById(id);

            // e bine sa verificam ca exista si sa prindem exceptiile care pot sa apara daca cumva ii empty
            if (imagineCazare.isEmpty()) {
                throw new EntityNotFoundException("Imaginea cu id = " + id + " nu a fost gasita!");
            }

            // cu .get() returnam obiectul "ascuns" in Optional
            return imagineCazare.get();
        }

        public List<ImagineCazare> findAll() {
            // findById returneaza un Optional, de aceea avem Optional aici
            return imagineCazareRepository.findAll();

        }

        public void delete(Integer id) {
            imagineCazareRepository.deleteById(id);
        }

        public ImagineCazare update(ImagineCazare imagineCazare) {
            Optional<ImagineCazare> oldImagineCazare = imagineCazareRepository.findById(imagineCazare.getId());

            if (oldImagineCazare.isEmpty()) {
                return null;
            }

            return imagineCazareRepository.save(imagineCazare);
        }
}
