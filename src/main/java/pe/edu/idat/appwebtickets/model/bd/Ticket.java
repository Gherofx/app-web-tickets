package pe.edu.idat.appwebtickets.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@Data
@Entity
@Table(name="tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ticket;
    @Column(name="preferencial")
    private String preferencial;
    @Column(name="con_pago")
    private Boolean con_pago;
    @Column(name="fecha_creacion")
    private Date fecha_creacion;
    @ManyToOne
    @JoinColumn(name="id_ciudadano")
    private Ciudadano ciudadano;
    @ManyToOne
    @JoinColumn(name="id_area")
    private Area area;
    @ManyToOne
    @JoinColumn(name="id_estado")
    private Ticket_estado ticket_estado;
    @ManyToOne
    @JoinColumn(name="idusuario")
    private Usuario usuario;

}
