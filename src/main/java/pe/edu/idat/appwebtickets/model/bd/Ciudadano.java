package pe.edu.idat.appwebtickets.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "ciudadano")
public class Ciudadano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idciu;

    @Column(name = "dniciu")
    private String dniciu;

    @Column(name = "nombresc")
    private String nombresc;

    @Column(name = "apellidosc")
    private String apellidosc;

    @Column(name = "direccionc")
    private String direccionc;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correoc")
    private String correoc;
}
