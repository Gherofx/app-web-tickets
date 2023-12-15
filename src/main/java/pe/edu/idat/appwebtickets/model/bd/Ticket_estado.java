package pe.edu.idat.appwebtickets.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="ticket_estados")
public class Ticket_estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_estado;
    @Column(name="nombre_estado")
    private String nombre_estado;
    @Column(name="estado")
    private Boolean estado;
}
