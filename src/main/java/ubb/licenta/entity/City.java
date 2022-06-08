package ubb.licenta.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ubb.licenta.dto.CityDto;

import javax.persistence.*;

@AllArgsConstructor // cu toti parametrii
@NoArgsConstructor // fara parametrii
@Getter
@Setter
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_city", unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id") // denumeste campul
    private Country country;

    public static City cityFromCityDto(CityDto cityDto) {
        City city = new City();
        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        city.setCountry(Country.countryFromCountryDto(cityDto.getCountryDto()));

        return city;
    }
}

