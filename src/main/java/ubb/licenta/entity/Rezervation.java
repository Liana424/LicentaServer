package ubb.licenta.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@AllArgsConstructor // cu toti parametrii
@NoArgsConstructor // fara parametrii
@Getter
@Setter
@Entity
@Table(name = "rezervation")
public class Rezervation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rezervation", unique = true, nullable = false)
    private Integer id;

    @Column(name = "total_price", nullable = false)
    private Double price;

    @Column(name = "date_check_in", nullable = false)
    private Timestamp dateCheckIn; //

    @Column(name = "date_check_out", nullable = false)
    private Timestamp dateCheckOut; //

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "room_rezervation_",
        joinColumns = @JoinColumn(name = "rezervation_id"),
        inverseJoinColumns = @JoinColumn(name = "room_id"))
    private Set<Room> rooms;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // denumeste campul
    private User user;
}
