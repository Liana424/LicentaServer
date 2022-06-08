package ubb.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ubb.licenta.entity.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}