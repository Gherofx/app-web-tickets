package pe.edu.idat.appwebtickets.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.appwebtickets.model.bd.*;
import pe.edu.idat.appwebtickets.model.request.TicketRequest;
import pe.edu.idat.appwebtickets.model.response.ResultadoResponse;
import pe.edu.idat.appwebtickets.repository.TicketRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketService {

    private TicketRepository ticketRepository;

    public List<Ticket> listarTickets(){
        return ticketRepository.findAll();
    }


    public ResultadoResponse guardarTicket(TicketRequest ticketRequest){
        String mensaje ="Ticket resgistrado correctamente";
        Boolean respuesta = true;
        try{
            Ticket ticket= new Ticket();
            if(ticketRequest.getId_ticket()>0){
                ticket.setId_ticket(ticketRequest.getId_ticket());
            }
            ticket.setPreferencial(ticketRequest.getPreferencial());
            ticket.setCon_pago(ticketRequest.getCon_pago());
            Boolean con_pago =false;
            if(ticketRequest.getCon_pago() !=null){
                con_pago = true;
            }
            ticket.setCon_pago(con_pago);
            ticket.setFecha_creacion(ticketRequest.getFecha_creacion());
            Ciudadano ciudadano = new Ciudadano();
            ciudadano.setId_ciudadano(ticketRequest.getId_ciudadano());
            Area area = new Area();
            area.setId_area(ticketRequest.getId_area());
            Ticket_estado ticket_estado = new Ticket_estado();
            ticket_estado.setId_estado(ticketRequest.getId_estado());
            Usuario usuario = new Usuario();
            usuario.setIdusuario(ticketRequest.getIdusuario());
            ticket.setCiudadano(ciudadano);
            ticket.setArea(area);
            ticket.setTicket_estado(ticket_estado);
            ticket.setUsuario(usuario);
            ticketRepository.save(ticket);
        }catch (Exception ex){
            mensaje = "Ticket no registrado";
            respuesta = false;

        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
