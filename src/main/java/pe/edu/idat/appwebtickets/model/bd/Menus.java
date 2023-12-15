package pe.edu.idat.appwebtickets.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name="menu")
public class Menus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmenu;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="icono")
    private String icono;
    @Column(name="controlador")
    private String controlador;
    @Column(name="pagina")
    private String pagina;
    @Column(name="esactivo")
    private Boolean esactivo;
    @Column(name="fecharegistro")
    private Date fecharegistro;
}
