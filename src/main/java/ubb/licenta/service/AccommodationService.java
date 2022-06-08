package ubb.licenta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import ubb.licenta.dto.AccommodationDto;

import ubb.licenta.entity.Accommodation;

import ubb.licenta.entity.City;

import ubb.licenta.repository.AccommodationRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccommodationService {
    private final AccommodationRepository accommodationRepository;

    public AccommodationDto insert(AccommodationDto accommodationDto) {
        Accommodation accommodation = new Accommodation();
        accommodation.setId(accommodationDto.getId());
        accommodation.setName(accommodationDto.getName());
        accommodation.setAddress(accommodationDto.getAddress());
        accommodation.setImage(accommodationDto.getImage());
        accommodation.setLink(accommodationDto.getLink());
        accommodation.setCity(City.cityFromCityDto(accommodationDto.getCityDto()));
        return AccommodationDto.accommodationDtoFromAccommodation(accommodationRepository.save(accommodation));
    }

    public AccommodationDto findById(Integer id) throws ChangeSetPersister.NotFoundException {
        return AccommodationDto.accommodationDtoFromAccommodation(accommodationRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new));
    }

    public AccommodationDto findByName(String name) throws ChangeSetPersister.NotFoundException {
        return AccommodationDto.accommodationDtoFromAccommodation(accommodationRepository.findByName(name).orElseThrow(ChangeSetPersister.NotFoundException::new));
    }


    public List<AccommodationDto> findAll() {
        // findById returneaza un Optional, de aceea avem Optional aici
        return accommodationRepository.findAll().stream().map(AccommodationDto::accommodationDtoFromAccommodation).collect(Collectors.toList());

    }

    public List<AccommodationDto> findAllByCity(String cityname) {
        return accommodationRepository.findAllByCity(cityname).stream().map(AccommodationDto::accommodationDtoFromAccommodation).collect(Collectors.toList());
    }

    public AccommodationDto update(AccommodationDto accommodationDto) {
        Accommodation accommodation = new Accommodation();
        accommodation.setId(accommodationDto.getId());
        accommodation.setName(accommodationDto.getName());
        accommodation.setAddress(accommodationDto.getAddress());
        accommodation.setImage(accommodationDto.getImage());
        accommodation.setLink(accommodationDto.getLink());
        accommodation.setCity(City.cityFromCityDto(accommodationDto.getCityDto()));
        return AccommodationDto.accommodationDtoFromAccommodation(accommodationRepository.save(accommodation));
    }


    public void delete(Integer id) {
        accommodationRepository.deleteById(id);
    }

}
