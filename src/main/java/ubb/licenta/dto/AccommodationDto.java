package ubb.licenta.dto;

import lombok.*;
import ubb.licenta.entity.Accommodation;


@AllArgsConstructor // cu toti parametrii
@NoArgsConstructor // fara parametrii
@Getter
@Setter
@Data
public class AccommodationDto {
    private Integer id;
    private String name;
    private String address;
    private String  image;
    private String  link;
    private CityDto cityDto;

    public static AccommodationDto accommodationDtoFromAccommodation(Accommodation accommodation) {
        AccommodationDto accommodationDto = new AccommodationDto();
        accommodationDto.setId(accommodation.getId());
        accommodationDto.setName(accommodation.getName());
        accommodationDto.setAddress(accommodation.getAddress());
        accommodationDto.setImage(accommodation.getImage());
        accommodationDto.setLink(accommodation.getLink());
        accommodationDto.setCityDto(CityDto.cityDtoFromCity(accommodation.getCity()));


        return accommodationDto;

    }
}
