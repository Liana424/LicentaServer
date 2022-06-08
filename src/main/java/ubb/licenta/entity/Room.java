package ubb.licenta.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import ubb.licenta.dto.RoomDto;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor // cu toti parametrii
@NoArgsConstructor // fara parametrii
@Getter
@Setter
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_room", unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String type;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false, length = 200)
    private String description;

    @Column(length = 500)
    private String  image;

    @ManyToMany(mappedBy = "rooms")
    private Set<Rezervation> rezervationsSet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rezervation_id") // denumeste campul
    private Rezervation rezervation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_id") // denumeste campul
    private Accommodation accommodation;

    public static Room roomFromRoomDto(RoomDto roomDto) {
        Room room = new Room();
        room.setId(roomDto.getId());
        room.setType(roomDto.getType());
        room.setPrice(roomDto.getPrice());
        room.setDescription(roomDto.getDescription());
        room.setImage(roomDto.getImage());
        room.setAccommodation(Accommodation.accommodationFromAccommodationDto(roomDto.getAccommodationDto()));

        return room;
    }
}

