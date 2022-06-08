package ubb.licenta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import ubb.licenta.entity.Contact;
import ubb.licenta.entity.Room;
import ubb.licenta.repository.ContactRepository;


import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional

public class ContactService {
    private final ContactRepository contactRepository;

    public Integer insert(Contact contact) {
        Contact savedContact = contactRepository.save(contact);

        return savedContact.getId();
    }

    public Contact findById(Integer id) {
        // findById returneaza un Optional, de aceea avem Optional aici
        Optional<Contact> contact = contactRepository.findById(id);

        // e bine sa verificam ca exista si sa prindem exceptiile care pot sa apara daca cumva ii empty
        if (contact.isEmpty()) {
            throw new EntityNotFoundException("Mesajul cu id = " + id + " nu a fost gasit!");
        }

        // cu .get() returnam obiectul "ascuns" in Optional
        return contact.get();
    }

    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }

    public Contact update(Contact contact) {
        Optional<Contact> oldContact = contactRepository.findById(contact.getId());

        if (oldContact.isEmpty()) {
            return null;
        }

        return contactRepository.save(contact);
    }
}
