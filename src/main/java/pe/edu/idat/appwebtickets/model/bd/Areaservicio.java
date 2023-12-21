package pe.edu.idat.appwebtickets.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "areaservicio")
public class Areaservicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idas;

    @ManyToOne
    @JoinColumn(name = "idarea")
    private Area area;

    @ManyToOne
    @JoinColumn(name = "idservicio")
    private Servicio servicio;
}
