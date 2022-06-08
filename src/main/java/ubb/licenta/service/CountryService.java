package ubb.licenta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import ubb.licenta.dto.CountryDto;
import ubb.licenta.entity.Country;
import ubb.licenta.repository.CountryRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional



public class CountryService {
    private final CountryRepository countryRepository;

    public CountryDto insert(CountryDto countryDto) {
        Country country = new Country();
        country.setId(countryDto.getId());
        country.setName(countryDto.getName());

        return CountryDto.countryDtoFromCountry(countryRepository.save(country));
    }

    public CountryDto findByName(String name) throws ChangeSetPersister.NotFoundException {
       return CountryDto.countryDtoFromCountry(countryRepository.findByName(name).orElseThrow(ChangeSetPersister.NotFoundException::new));
    }

    public CountryDto findById(Integer id) throws ChangeSetPersister.NotFoundException {
        return CountryDto.countryDtoFromCountry(countryRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new));
    }

    public List<CountryDto> findAll() {
        // findById returneaza un Optional, de aceea avem Optional aici
        return countryRepository.findAll().stream().map(CountryDto::countryDtoFromCountry).collect(Collectors.toList());

    }

    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }

    public CountryDto update(CountryDto countryDto) {
        Country country = new Country();
        country.setId(countryDto.getId());
        country.setName(countryDto.getName());

        return CountryDto.countryDtoFromCountry(countryRepository.save(country));
    }


}
