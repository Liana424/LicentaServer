package ubb.licenta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ubb.licenta.entity.Rezervation;
import ubb.licenta.service.RezervationService;

import java.util.List;

@RestController
@CrossOrigin // pt cand facem request de pe front end care ruleaza de pe alt port
@RequiredArgsConstructor
@RequestMapping(value = "/rezervation")
public class RezervationController {
    private final RezervationService rezervationService;

    @PostMapping()
    public Integer insert(@RequestBody Rezervation rezervation) {
        Integer id = rezervationService.insert(rezervation);

        return id;
    }

    @GetMapping(value = "/id={id}")
    public Rezervation findById(@PathVariable("id") Integer id) {
        Rezervation rezervation = rezervationService.findById(id);

        return rezervation;
    }

    @GetMapping()
    public List<Rezervation> findAll() {
        return rezervationService.findAll();
    }

    @DeleteMapping(value = "/id={id}")
    public void deleteRezervation(@PathVariable("id") Integer id) {
        rezervationService.delete(id);
    }

    @PutMapping()
    public Rezervation updateRezervation(@RequestBody Rezervation rezervation) {
        return rezervationService.update(rezervation);
    }

}
