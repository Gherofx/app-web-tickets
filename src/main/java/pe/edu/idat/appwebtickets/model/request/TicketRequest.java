package pe.edu.idat.appwebtickets.model.request;

import lombok.Data;
@Data
public class TicketRequest {
    private Integer idticket;
    private Integer idciu;
    private Integer idarea;
    private Integer idstatus;
    private Boolean preferencial;
    private String fregistro;
    private String observacion;
}
