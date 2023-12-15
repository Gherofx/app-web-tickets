package pe.edu.idat.appwebtickets.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.appwebtickets.model.bd.Ticket;
import pe.edu.idat.appwebtickets.model.request.TicketRequest;
import pe.edu.idat.appwebtickets.model.response.ResultadoResponse;
import pe.edu.idat.appwebtickets.service.TicketService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/backoffice/ticket")
public class TicketController {

    private TicketService ticketService;

    @GetMapping("")
    public String frmMantTicket(Model model){
        model.addAttribute("listartickets",
                ticketService.listarTickets());
        return"backoffice/ticket/frmticket";
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<Ticket> listartickets(){
        return ticketService.listarTickets();
    }

    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarTicket(@RequestBody TicketRequest ticketRequest){
        return ticketService.guardarTicket(ticketRequest);
    }

}
