package pe.edu.idat.appwebtickets.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name="ciudadanos")
public class Ciudadano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ciudadano;
    @Column(name="nombres")
    private String nombres;
    @Column(name="apellidos")
    private String apellidos;
    @Column(name="direccion")
    private String direccion;
    @Column(name="dni_ciudadano")
    private  String dni_ciudadano;
    @Column(name="telefono")
    private String telefono;
    @Column(name="email")
    private String email;
    @Column(name="preferencial")
    private Boolean preferencial;
    @Column(name="esactivo")
    private  Boolean esactivo;
    @Column(name="fecha_creacion")
    private Date fecha_creacion;
    @Column(name="fecha_modificacion")
    private Date fecha_modificacion;

}
