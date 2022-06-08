package ubb.licenta.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ubb.licenta.dto.ReservationDetailsDto;
import ubb.licenta.entity.Event;
import ubb.licenta.repository.EventRepository;

import javax.persistence.EntityNotFoundException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {
        private final EventRepository eventRepository;

        public Integer insert(Event event) {
            Event savedEvent = eventRepository.save(event);

            return savedEvent.getId();
        }

        public Event findById(Integer id) {
            // findById returneaza un Optional, de aceea avem Optional aici
            Optional<Event> event = eventRepository.findById(id);

            // e bine sa verificam ca exista si sa prindem exceptiile care pot sa apara daca cumva ii empty
            if (event.isEmpty()) {
                throw new EntityNotFoundException("Evenimentul cu id = " + id + " nu a fost gasit!");
            }

            // cu .get() returnam obiectul "ascuns" in Optional
            return event.get();
        }

       /* public Event findByName(String name) {
            // aici folosim query-ul nostru custom
            Optional<Event> event = eventRepository.findByName(name);

            // e bine sa verificam ca exista si sa prindem exceptiile care pot sa apara daca cumva ii empty
            if (event.isEmpty()) {
                throw new EntityNotFoundException("Evenimentul cu denumirea = " + event + " nu a fost gasit!");
            }

            // cu .get() returnam obiectul "ascuns" in Optional
            return event.get();
        } */

        public List<Event> findAllByCity(String cityname) {
            return eventRepository.findAllByCity(cityname);
        }

        public List<Event> findAllEventsFromCityBetweenDates(ReservationDetailsDto reservationDetailsDto){
            List<Event> eventList = eventRepository.findAllByCity(reservationDetailsDto.getCityName());
            List<Event> filteredEventList = new ArrayList<>();
            for (Event event:eventList){
                if(!event.getDateStart().after(reservationDetailsDto.getStartDate()) && !event.getDateFinal().before(reservationDetailsDto.getStartDate())) {
                    filteredEventList.add(event);
                } else if(!event.getDateStart().before(reservationDetailsDto.getStartDate()) && !event.getDateFinal().after(reservationDetailsDto.getEndDate())) {
                    filteredEventList.add(event);
                } else if(!event.getDateStart().before(reservationDetailsDto.getStartDate()) && !event.getDateStart().after(reservationDetailsDto.getEndDate()) &&
                        !event.getDateFinal().before(reservationDetailsDto.getEndDate())) {
                    filteredEventList.add(event);
                }
            }

            return filteredEventList;
        }

        public List<Event> findAll() {
            // findById returneaza un Optional, de aceea avem Optional aici
            return eventRepository.findAll();

        }

        public Event update(Event event) {
            Optional<Event> oldEvent = eventRepository.findById(event.getId());

            if (oldEvent.isEmpty()) {
                return null;
            }

            return eventRepository.save(event);
        }


        public void delete(Integer id) {
            eventRepository.deleteById(id);
        }

    }
