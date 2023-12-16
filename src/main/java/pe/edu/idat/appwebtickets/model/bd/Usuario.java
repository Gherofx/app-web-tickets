package pe.edu.idat.appwebtickets.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
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
    @Column(name="correo")
    private String correo;
    @Column(name="nombres")
    private String nombres;
    @Column(name="apellidos")
    private String apellidos;
    @Column(name="dni")
    private String dni;
    @Column(name="esactivo")
    private Boolean esactivo;
    @ManyToMany(cascade = CascadeType.MERGE,
    fetch = FetchType.EAGER)
    @JoinTable(name="usuario_rol", joinColumns = @JoinColumn(name = "idusuario"),
    inverseJoinColumns = @JoinColumn(name = "idrol"))
    private Set<Rol> roles;
}
