package ubb.licenta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import ubb.licenta.dto.AccommodationDto;

import ubb.licenta.service.AccommodationService;

import java.util.List;

@RestController
@CrossOrigin // pt cand facem request de pe front end care ruleaza de pe alt port
@RequiredArgsConstructor
@RequestMapping(value = "/accommodation")
public class AccommodationController {
    private final AccommodationService accommodationService;

    @PostMapping()
    public AccommodationDto insert(@RequestBody AccommodationDto accommodationDto) {
        return accommodationService.insert(accommodationDto);
    }

    @GetMapping(value = "/id={id}")
    public AccommodationDto findById(@PathVariable("id") Integer id) throws ChangeSetPersister.NotFoundException {
        return accommodationService.findById(id);
    }

    @GetMapping(value = "/name={name}")
    public AccommodationDto findByName(@PathVariable("name") String name) throws ChangeSetPersister.NotFoundException {
        return accommodationService.findByName(name);
    }

    @GetMapping()
    public List<AccommodationDto> findAll() {
        return accommodationService.findAll();
    }

    @GetMapping(value = "/cityname={cityname}")
    public List<AccommodationDto> findAllByCity(@PathVariable("cityname") String cityname){  //
        return accommodationService.findAllByCity(cityname);
    }



    @PutMapping()
    public AccommodationDto updateAccommodation(@RequestBody AccommodationDto accommodationDto) {
        return accommodationService.update(accommodationDto);
    }

    @DeleteMapping(value = "/id={id}")
    public void deleteAccommodation(@PathVariable("id") Integer id) {
        accommodationService.delete(id);
    }
}
