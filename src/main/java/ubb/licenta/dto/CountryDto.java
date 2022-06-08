package ubb.licenta.dto;

import lombok.*;
import ubb.licenta.entity.Country;

@AllArgsConstructor // cu toti parametrii
@NoArgsConstructor // fara parametrii
@Getter
@Setter
@Data

public class CountryDto {
    private Integer id;
    private String name;

    public static CountryDto countryDtoFromCountry(Country country){
        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());

        return  countryDto;
    }
}
