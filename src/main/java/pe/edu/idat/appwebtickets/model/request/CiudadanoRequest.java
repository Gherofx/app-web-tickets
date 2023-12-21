package pe.edu.idat.appwebtickets.model.request;

import lombok.Data;

@Data
public class CiudadanoRequest {
    private Integer idciu;
    private String dniciu;
    private String nombresc;
    private String apellidosc;
    private String direccionc;
    private String telefono;
    private String correoc;
}
