package ubb.licenta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ubb.licenta.entity.Contact;

import ubb.licenta.entity.Event;
import ubb.licenta.service.ContactService;

import java.util.List;

@RestController
@CrossOrigin // pt cand facem request de pe front end care ruleaza de pe alt port
@RequiredArgsConstructor
@RequestMapping(value = "/contact")

public class ContactController {
    private final ContactService contactService;

    @PostMapping()
    public Integer insert(@RequestBody Contact contact) {
        Integer id = contactService.insert(contact);

        return id;
    }

    @GetMapping(value = "/id={id}")
    public Contact findById(@PathVariable("id") Integer id) {
        Contact contact = contactService.findById(id);

        return contact;
    }

    @PutMapping()
    public Contact updateEvent(@RequestBody Contact contact) {
        return contactService.update(contact);
    }

    @DeleteMapping(value = "/id={id}")
    public void deleteEvent(@PathVariable("id") Integer id) {
        contactService.delete(id);
    }

}
