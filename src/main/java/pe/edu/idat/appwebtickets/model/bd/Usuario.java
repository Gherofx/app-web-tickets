package pe.edu.idat.appwebtickets.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;
    @Column(name="usuario")
    private String usuario;
    @Column(name="clave")
    private String clave;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellidos")
    private String apellidos;
    @Column(name="dni")
    private String dni;
    @Column(name="direccion")
    private String direccion;
    @Column(name="correo")
    private String correo;
    @Column(name="telefono")
    private String telefono;
    @Column(name="urlfoto")
    private String urlfoto;
    @Column(name="nombrefoto")
    private String nombrefoto;
    @Column(name="esactivo")
    private Boolean esactivo;
    @Column(name="fecharegistro")
    private Date fecharegistro;
    @Column(name="fechamodificacion")
    private Date fechamodificacion;
    @ManyToOne
    @JoinColumn(name="idrol")
    private Rol rol;
}
