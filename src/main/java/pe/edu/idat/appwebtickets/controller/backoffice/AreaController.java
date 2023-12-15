package pe.edu.idat.appwebtickets.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.idat.appwebtickets.model.bd.Area;
import pe.edu.idat.appwebtickets.service.AreaService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/backoffice/area")
public class AreaController {
    private AreaService areaService;

    @GetMapping("/listar")
    @ResponseBody
    public List<Area> listarareas(){
        return areaService.listarAreas();
    }
}
