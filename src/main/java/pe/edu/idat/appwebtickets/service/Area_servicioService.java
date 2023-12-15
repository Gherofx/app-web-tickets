package pe.edu.idat.appwebtickets.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.appwebtickets.model.bd.Area_servicio;

import pe.edu.idat.appwebtickets.repository.Area_servicioRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class Area_servicioService {

    private Area_servicioRepository area_servicioRepository;

    public List<Area_servicio> listarArea_servicios(){
        return area_servicioRepository.findAll();
    }
}
