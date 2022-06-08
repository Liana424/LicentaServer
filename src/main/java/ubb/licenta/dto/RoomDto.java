package ubb.licenta.dto;


import lombok.*;
import ubb.licenta.entity.Accommodation;
import ubb.licenta.entity.City;
import ubb.licenta.entity.Room;

@AllArgsConstructor // cu toti parametrii
@NoArgsConstructor // fara parametrii
@Getter
@Setter
@Data
public class RoomDto {
    private Integer id;
    private String type;
    private Double price;
    private String description;
    private String  image;
    private AccommodationDto accommodationDto;

    public static RoomDto roomDtoFromRoom(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setId(room.getId());
        roomDto.setType(room.getType());
        roomDto.setPrice(room.getPrice());
        roomDto.setDescription(room.getDescription());
        roomDto.setImage(room.getImage());
        roomDto.setAccommodationDto(AccommodationDto.accommodationDtoFromAccommodation(room.getAccommodation()));


        return roomDto;
    }

}
