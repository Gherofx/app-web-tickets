package pe.edu.idat.appwebtickets.controller.backoffice;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.idat.appwebtickets.model.bd.Area_servicio;
import pe.edu.idat.appwebtickets.service.Area_servicioService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/backoffice/area_servicio")
public class Area_servicioController {
    private Area_servicioService area_servicioService;

    @GetMapping("/listar")
    @ResponseBody
    public List<Area_servicio> listarArea_servicios(){
        return area_servicioService.listarArea_servicios();
    }
}
