package ubb.licenta.dto;

import lombok.*;
import ubb.licenta.entity.City;
import ubb.licenta.entity.Country;

@AllArgsConstructor // cu toti parametrii
@NoArgsConstructor // fara parametrii
@Getter
@Setter
@Data

public class CityDto {
    private Integer id;
    private String name;
    private CountryDto countryDto;

    public static CityDto cityDtoFromCity(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        cityDto.setCountryDto(CountryDto.countryDtoFromCountry(city.getCountry()));


        return cityDto;
    }


}
