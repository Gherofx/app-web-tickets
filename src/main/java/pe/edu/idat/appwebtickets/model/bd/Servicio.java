package pe.edu.idat.appwebtickets.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_servicio;
    @Column(name="nombre_servicio")
    private String nombre_servicio;
    @Column(name="esactivo")
    private Boolean esactivo;

}