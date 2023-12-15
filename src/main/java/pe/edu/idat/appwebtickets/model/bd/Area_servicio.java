package pe.edu.idat.appwebtickets.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="area_servicios")
public class Area_servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_area_servicio;
    @ManyToOne
    @JoinColumn(name="id_area")
    private Area area;
    @ManyToOne
    @JoinColumn(name="id_servicio")
    private Servicio servicio;

}
