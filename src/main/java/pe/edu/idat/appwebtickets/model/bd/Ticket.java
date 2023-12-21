package pe.edu.idat.appwebtickets.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idticket;

    @Column(name = "preferencial")
    private Boolean preferencial;

    @Column(name = "fregistro")
    private String fregistro;

    @Column(name = "observacion")
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "idciu")
    private Ciudadano ciudadano;

    @ManyToOne
    @JoinColumn(name = "idarea")
    private Area area;

    @ManyToOne
    @JoinColumn(name = "idstatus")
    private Status status;
}
