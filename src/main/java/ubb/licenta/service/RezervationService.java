package ubb.licenta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ubb.licenta.entity.Rezervation;
import ubb.licenta.repository.RezervationRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RezervationService {
    private final RezervationRepository rezervationRepository;

    public Integer insert(Rezervation rezervation) {
        Rezervation savedRezervation = rezervationRepository.save(rezervation);

        return savedRezervation.getId();
    }


    public Rezervation findById(Integer id) {
        // findById returneaza un Optional, de aceea avem Optional aici
        Optional<Rezervation> rezervation = rezervationRepository.findById(id);

        // e bine sa verificam ca exista si sa prindem exceptiile care pot sa apara daca cumva ii empty
        if (rezervation.isEmpty()) {
            throw new EntityNotFoundException("Rezervarea cu id = " + id + " nu a fost gasita!");
        }

        // cu .get() returnam obiectul "ascuns" in Optional
        return rezervation.get();
    }

    public List<Rezervation> findAll() {
        // findById returneaza un Optional, de aceea avem Optional aici
        return rezervationRepository.findAll();

    }

    public void delete(Integer id) {
        rezervationRepository.deleteById(id);
    }

    public Rezervation update(Rezervation rezervation) {
        Optional<Rezervation> oldRezervation = rezervationRepository.findById(rezervation.getId());

        if (oldRezervation.isEmpty()) {
            return null;
        }

        return rezervationRepository.save(rezervation);
    }
}
