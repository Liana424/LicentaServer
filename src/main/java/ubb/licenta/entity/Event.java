package ubb.licenta.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor // cu toti parametrii
@NoArgsConstructor // fara parametrii
@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event", unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name = "event_type", nullable = false, length = 100)
    private String type;

    // @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false)
    private Timestamp dateStart; //

   //  @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "final_date", nullable = false)
    private Timestamp dateFinal; //

    @Column(length = 200)
    private String  description;

    @Column(length = 500)
    private String  link;

    @Column(length = 500)
    private String  image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id") // denumeste campul
    private City city;
}
