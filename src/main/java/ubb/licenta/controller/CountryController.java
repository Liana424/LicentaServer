package ubb.licenta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import ubb.licenta.dto.CountryDto;
import ubb.licenta.entity.Country;
import ubb.licenta.service.CountryService;

import java.util.List;

@RestController
@CrossOrigin // pt cand facem request de pe front end care ruleaza de pe alt port
@RequiredArgsConstructor
@RequestMapping(value = "/country")
public class CountryController {
    private final CountryService countryService;

    @PostMapping()
    public CountryDto insert(@RequestBody CountryDto countryDto) {
        return countryService.insert(countryDto);
    }

    // cu toate ca aceste 2 metode de mai jos sunt ambele de tip Get
    // controllerul stie pe care sa o cheme in functie de path, adica in functie de ce ii dupa /
    // aici de exemplu avem denumire care asteapta un String
    @GetMapping(value = "/name={name}")
    public CountryDto findByName(@PathVariable("name") String name) throws ChangeSetPersister.NotFoundException {
        return countryService.findByName(name);
    }

    // iar aici avem un Integer
    @GetMapping(value = "/id={id}")
    public CountryDto findById(@PathVariable("id") Integer id) throws ChangeSetPersister.NotFoundException {
        return  countryService.findById(id);
    }

    @GetMapping()
    public List<CountryDto> findAll() {
        return countryService.findAll();
    }

    @DeleteMapping(value = "/id={id}")
    public void deleteCountry(@PathVariable("id") Integer id) {
        countryService.delete(id);
    }

    @PutMapping()
    public CountryDto updateCountry(@RequestBody CountryDto countryDto) {
        return countryService.update(countryDto);
    }

}

