package ubb.licenta.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ubb.licenta.dto.AccommodationDto;


import javax.persistence.*;

@AllArgsConstructor // cu toti parametrii
@NoArgsConstructor // fara parametrii
@Getter
@Setter
@Entity
@Table(name = "accommodation")

public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_accommodation", unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(length = 500)
    private String  image;

    @Column(length = 500)
    private String  link;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id") // denumeste campul
    private City city;

    public static Accommodation accommodationFromAccommodationDto(AccommodationDto accommodationDto) {
        Accommodation accommodation = new Accommodation();
        accommodation.setId(accommodationDto.getId());
        accommodation.setName(accommodationDto.getName());
        accommodation.setAddress(accommodationDto.getAddress());
        accommodation.setImage(accommodationDto.getImage());
        accommodation.setLink(accommodationDto.getLink());
        accommodation.setCity(City.cityFromCityDto(accommodationDto.getCityDto()));

        return accommodation;
    }

}
