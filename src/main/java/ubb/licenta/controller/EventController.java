package ubb.licenta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import ubb.licenta.dto.ReservationDetailsDto;
import ubb.licenta.entity.Event;
import ubb.licenta.service.EventService;

import java.util.List;

@RestController
@CrossOrigin // pt cand facem request de pe front end care ruleaza de pe alt port
@RequiredArgsConstructor
@RequestMapping(value = "/event")
public class EventController {
    private final EventService eventService;

    @PostMapping()
    public Integer insert(@RequestBody Event event) {
        Integer id = eventService.insert(event);

        return id;
    }

    @GetMapping(value = "/id={id}")
    public Event findById(@PathVariable("id") Integer id) {
        Event event = eventService.findById(id);

        return event;
    }

  /*  @GetMapping(value = "/name={name}")
    public Event findByName(@PathVariable("name") String name) {
        Event event = eventService.findByName(name);

        return event;
    } */

    @GetMapping(value = "/cityname={cityname}")
    public List<Event> findAllByCity(@PathVariable("cityname") String cityname){  //
        return eventService.findAllByCity(cityname);
    }

//    @GetMapping(value = "/filtered/startDate={startDate}&endDate={endDate}&cityName={cityName}")
//    public List<Event> findAllEventsFromCityBetweenDates(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate, @PathVariable("cityName") String cityName) {
//        ReservationDetailsDto reservationDetailsDto = new ReservationDetailsDto();
//        reservationDetailsDto.setStartDate(startDate);
//        reservationDetailsDto.setEndDate(endDate);
//        reservationDetailsDto.setCityName(cityName);
//        return eventService.findAllEventsFromCityBetweenDates(reservationDetailsDto);
//    }

    @PostMapping(value = "/filtered")
    public List<Event> findAllEventsFromCityBetweenDates(@RequestBody ReservationDetailsDto reservationDetailsDto){
        return eventService.findAllEventsFromCityBetweenDates(reservationDetailsDto);
    }

    @GetMapping()
    public List<Event> findAll() {
        return eventService.findAll();
    }

    @PutMapping()
    public Event updateEvent(@RequestBody Event event) {
        return eventService.update(event);
    }

    @DeleteMapping(value = "/id={id}")
    public void deleteEvent(@PathVariable("id") Integer id) {
        eventService.delete(id);
    }
}
