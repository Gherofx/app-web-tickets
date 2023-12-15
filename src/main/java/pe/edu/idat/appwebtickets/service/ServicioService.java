package pe.edu.idat.appwebtickets.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.appwebtickets.model.bd.Servicio;
import pe.edu.idat.appwebtickets.repository.ServicioRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioService {

    private ServicioRepository servicioRepository;

    public List<Servicio> listarServicios(){
        return servicioRepository.findAll();
    }
}
