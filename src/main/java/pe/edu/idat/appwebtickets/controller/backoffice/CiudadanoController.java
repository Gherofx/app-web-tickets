package pe.edu.idat.appwebtickets.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.appwebtickets.model.bd.Ciudadano;
import pe.edu.idat.appwebtickets.model.request.CiudadanoRequest;
import pe.edu.idat.appwebtickets.model.response.ResultadoResponse;
import pe.edu.idat.appwebtickets.service.CiudadanoService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/backoffice/ciudadano")
public class CiudadanoController {
    private CiudadanoService ciudadanoService;
    @GetMapping("")
    public  String frmMantCiudadano(Model model){
        model.addAttribute("listaciudadanos", ciudadanoService.listarCiudadanos());
        return  "backoffice/ciudadano/frmciudadano";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<Ciudadano> listarCiudadanos(){
        return ciudadanoService.listarCiudadanos();
    }

    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarCiudadano(@RequestBody CiudadanoRequest ciudadanoRequest){
        return ciudadanoService.guardarCiudadano(ciudadanoRequest);
    }
}
