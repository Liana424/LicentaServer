package ubb.licenta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import ubb.licenta.dto.CityDto;
import ubb.licenta.dto.RoomDto;
import ubb.licenta.entity.Accommodation;
import ubb.licenta.entity.City;
import ubb.licenta.entity.Country;
import ubb.licenta.entity.Room;
import ubb.licenta.repository.RoomRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomDto insert(RoomDto roomDto) {
        Room room = new Room();
        room.setId(roomDto.getId());
        room.setType(roomDto.getType());
        room.setPrice(roomDto.getPrice());
        room.setDescription(roomDto.getDescription());
        room.setImage(roomDto.getImage());
        room.setAccommodation(Accommodation.accommodationFromAccommodationDto(roomDto.getAccommodationDto()));
        return RoomDto.roomDtoFromRoom(roomRepository.save(room));
    }

   /* public List<Room> findAllByTip(String type) {
        // aici folosim query-ul nostru custom
        List<Room> room = roomRepository.findAllByType(type);

        // e bine sa verificam ca exista si sa prindem exceptiile care pot sa apara daca cumva ii empty
        if (room.isEmpty()) {
            throw new EntityNotFoundException("Camera de tipul = " + type + " nu a fost gasita!");
        }

        // cu .get() returnam obiectul "ascuns" in Optional
        return roomRepository.findAllByType(type);
    } */

    public RoomDto findById(Integer id) throws ChangeSetPersister.NotFoundException {
        return RoomDto.roomDtoFromRoom(roomRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new));
    }

    public List<RoomDto> findAll() {
        // findById returneaza un Optional, de aceea avem Optional aici
        return roomRepository.findAll().stream().map(RoomDto::roomDtoFromRoom).collect(Collectors.toList());

    }

    public List<RoomDto> findAllByAccommodation(String accommodationname) {
        return roomRepository.findAllByAccommodation(accommodationname).stream().map(RoomDto::roomDtoFromRoom).collect(Collectors.toList());
    }

    public RoomDto update(RoomDto roomDto) {
        Room room = new Room();
        room.setId(roomDto.getId());
        room.setType(roomDto.getType());
        room.setPrice(roomDto.getPrice());
        room.setDescription(roomDto.getDescription());
        room.setImage(roomDto.getImage());
        room.setAccommodation(Accommodation.accommodationFromAccommodationDto(roomDto.getAccommodationDto()));
        return RoomDto.roomDtoFromRoom(roomRepository.save(room));
    }

    public void delete(Integer id) {
        roomRepository.deleteById(id);
    }
}
