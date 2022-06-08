package ubb.licenta.dto;


import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor // cu toti parametrii
@NoArgsConstructor // fara parametrii
@Getter
@Setter
@Data
public class ReservationDetailsDto {
    private Timestamp startDate;
    private Timestamp endDate;
    private String cityName;

}
