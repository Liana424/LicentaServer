package ubb.licenta.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor // cu toti parametrii
@NoArgsConstructor // fara parametrii
@Getter
@Setter
@Entity
@Table(name = "imagine_camera")
public class ImagineCamera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_img_cam", unique = true, nullable = false)
    private Integer id;

    @Column(name = "cod_cam", nullable = false, length = 50)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camera_id") // denumeste campul
    private Room room;
}
