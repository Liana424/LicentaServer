package ubb.licenta.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ubb.licenta.dto.CountryDto;

import javax.persistence.*;

@AllArgsConstructor // cu toti parametrii
@NoArgsConstructor // fara parametrii
@Getter
@Setter
@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_country", unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    public static Country countryFromCountryDto(CountryDto countryDto){
        Country country = new Country();
        country.setId(countryDto.getId());
        country.setName(countryDto.getName());

        return  country;
    }

}
