package pe.edu.idat.appwebtickets.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="areas")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_area;
    @Column(name="nombre_area")
    private String nombre_area;
    @Column(name="esactivo")
    private Boolean esactivo;
}
