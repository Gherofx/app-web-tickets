package pe.edu.idat.appwebtickets.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.appwebtickets.model.bd.Area;
import pe.edu.idat.appwebtickets.model.bd.Ciudadano;
import pe.edu.idat.appwebtickets.model.bd.Status;
import pe.edu.idat.appwebtickets.model.bd.Ticket;
import pe.edu.idat.appwebtickets.model.request.TicketRequest;
import pe.edu.idat.appwebtickets.model.response.ResultadoResponse;
import pe.edu.idat.appwebtickets.repository.TicketRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class TicketService {
    private TicketRepository ticketRepository;

    public List<Ticket> listarTickets(){return ticketRepository.findAll();}

    public ResultadoResponse guardarTicket(TicketRequest ticketRequest) {
        String mensaje = "Operación exitosa";
        Boolean respuesta = true;
        try{
            Ticket ticket = new Ticket();
            if (ticketRequest.getIdticket()>0){
                ticket.setIdticket(ticketRequest.getIdticket());
            }
            ticket.setPreferencial(ticketRequest.getPreferencial());
            ticket.setObservacion(ticketRequest.getObservacion());
            ticket.setFregistro(ticketRequest.getFregistro());

            Status status = new Status();
            status.setIdstatus(ticketRequest.getIdstatus());

            Ciudadano ciudadano = new Ciudadano();
            ciudadano.setIdciu(ticketRequest.getIdciu());

            Area area = new Area();
            area.setIdarea(ticketRequest.getIdarea());

            ticket.setStatus(status);
            ticket.setCiudadano(ciudadano);
            ticket.setArea(area);

            ticketRepository.save(ticket);
        }catch (Exception ex) {
            mensaje = "Error en la operación";
            respuesta = false;
        }

        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
