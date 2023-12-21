package pe.edu.idat.appwebtickets.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.idat.appwebtickets.model.bd.Status;
import pe.edu.idat.appwebtickets.service.StatusService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/backoffice/status")
public class StatusController {
    private StatusService statusService;
    @GetMapping("/listar")
    @ResponseBody
    public List<Status> listarStatusTicket(){
        return statusService.listarStatus();
    }
}
