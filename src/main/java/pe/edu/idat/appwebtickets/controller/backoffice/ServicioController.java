package pe.edu.idat.appwebtickets.controller.backoffice;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.idat.appwebtickets.model.bd.Servicio;
import pe.edu.idat.appwebtickets.service.ServicioService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/backoffice/servicio")
public class ServicioController {
    private ServicioService servicioService;

    @GetMapping("/listar")
    @ResponseBody
    public List<Servicio> listarServicios(){
        return servicioService.listarServicios();
    }
}
