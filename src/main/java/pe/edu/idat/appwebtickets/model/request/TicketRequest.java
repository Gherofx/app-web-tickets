package pe.edu.idat.appwebtickets.model.request;

import lombok.Data;


import java.util.Date;

@Data
public class TicketRequest {

    private Integer id_ticket;
    private String preferencial;
    private Boolean con_pago;
    private Date fecha_creacion;
    private Integer id_ciudadano;
    private Integer id_area;
    private Integer id_estado;
    private Integer idusuario;
}
