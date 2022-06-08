package ubb.licenta.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ubb.licenta.dto.CityDto;
import ubb.licenta.entity.City;

import ubb.licenta.entity.Country;
import ubb.licenta.repository.CityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional



public class CityService {
    private final CityRepository cityRepository;

    public CityDto insert(CityDto cityDto) {
        City city = new City();
        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        city.setCountry(Country.countryFromCountryDto(cityDto.getCountryDto()));
        return CityDto.cityDtoFromCity(cityRepository.save(city));
    }

    public CityDto findById(Integer id) throws ChangeSetPersister.NotFoundException {
        return CityDto.cityDtoFromCity(cityRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new));
    }
    public CityDto findByName(String name) throws ChangeSetPersister.NotFoundException {
        return CityDto.cityDtoFromCity(cityRepository.findByName(name).orElseThrow(ChangeSetPersister.NotFoundException::new));
    }

    public List<CityDto> findAllByCountry(String countryname) {
        return cityRepository.findAllByCountry(countryname).stream().map(CityDto::cityDtoFromCity).collect(Collectors.toList());
    }

    public List<CityDto> findAll() {
        // findById returneaza un Optional, de aceea avem Optional aici
        return cityRepository.findAll().stream().map(CityDto::cityDtoFromCity).collect(Collectors.toList());

    }

    public CityDto update(CityDto cityDto) {
        City city = new City();
        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        city.setCountry(Country.countryFromCountryDto(cityDto.getCountryDto()));
        return CityDto.cityDtoFromCity(cityRepository.save(city));
    }

    public void delete(Integer id) {
        cityRepository.deleteById(id);
    }
}
