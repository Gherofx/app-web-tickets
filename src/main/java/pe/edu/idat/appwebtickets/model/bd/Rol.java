package pe.edu.idat.appwebtickets.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name="roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrol;@Column(name="descripcion")

    private String descripcion;
    @Column(name="esactivo")
    private Boolean esactivo;
    @Column(name="fecharegistro")
    private Date fecharegistro;
}
