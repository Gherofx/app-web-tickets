package pe.edu.idat.appwebtickets.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name="rol_menu")
public class Rol_menus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrolvista;
    @Column(name="esactivo")
    private Boolean esactivo;
    @Column(name="fecharegistro")
    private Date fecharegistro;
    @ManyToOne
    @JoinColumn(name="idmenu")
    private Rol_menus rol_menus;
    @ManyToOne
    @JoinColumn(name="idrol")
    private Rol rol;

}
