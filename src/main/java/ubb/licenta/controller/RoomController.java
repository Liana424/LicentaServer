package ubb.licenta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import ubb.licenta.dto.CityDto;
import ubb.licenta.dto.RoomDto;
import ubb.licenta.entity.Room;

import ubb.licenta.service.RoomService;

import java.util.List;

@RestController
@CrossOrigin // pt cand facem request de pe front end care ruleaza de pe alt port
@RequiredArgsConstructor
@RequestMapping(value = "/room")
public class RoomController {
    private final RoomService roomService;

    @PostMapping()
    public RoomDto insert(@RequestBody RoomDto roomDto) {
        return roomService.insert(roomDto);
    }
    @GetMapping(value = "/id={id}")
    public RoomDto findById(@PathVariable("id") Integer id) throws ChangeSetPersister.NotFoundException {
        return roomService.findById(id);
    }

   /* @GetMapping(value = "/type={type}")
    public List<Room> findAllByTip(@PathVariable("type") String type) {
        return roomService.findAllByTip(type);
    } */

    @GetMapping()
    public List<RoomDto> findAll() {
        return roomService.findAll();
    }

    @GetMapping(value = "/accommodationname={accommodationname}")
    public List<RoomDto> findAllByCountry(@PathVariable("accommodationname") String accommodationname){  //
        return roomService.findAllByAccommodation(accommodationname);
    }


    @PutMapping()
    public RoomDto updateRoom(@RequestBody RoomDto roomDto) {
        return roomService.update(roomDto);
    }

    @DeleteMapping(value = "/id={id}")
    public void deleteRoom(@PathVariable("id") Integer id) {
        roomService.delete(id);
    }
}
