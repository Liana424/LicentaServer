package ubb.licenta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import ubb.licenta.dto.CityDto;

import ubb.licenta.service.CityService;

import java.util.List;

@RestController
@CrossOrigin // pt cand facem request de pe front end care ruleaza de pe alt port
@RequiredArgsConstructor
@RequestMapping(value = "/city")
public class CityController {
    private final CityService cityService;

    @PostMapping()
    public CityDto insert(@RequestBody CityDto cityDto) {
        return cityService.insert(cityDto);
    }

    @GetMapping(value = "/id={id}")
    public CityDto findById(@PathVariable("id") Integer id) throws ChangeSetPersister.NotFoundException {
        return cityService.findById(id);
    }

    @GetMapping(value = "/name={name}")
    public CityDto findByName(@PathVariable("name") String name) throws ChangeSetPersister.NotFoundException {
        return cityService.findByName(name);
    }

    @GetMapping(value = "/countryname={countryname}")
    public List<CityDto> findAllByCountry(@PathVariable("countryname") String countryname){  //
        return cityService.findAllByCountry(countryname);
    }

    @GetMapping()
    public List<CityDto> findAll() {
        return cityService.findAll();
    }

    @PutMapping()
    public CityDto updateCity(@RequestBody CityDto cityDto) {
        return cityService.update(cityDto);
    }

    @DeleteMapping(value = "/id={id}")
    public void deleteCity(@PathVariable("id") Integer id) {
        cityService.delete(id);
    }


}
