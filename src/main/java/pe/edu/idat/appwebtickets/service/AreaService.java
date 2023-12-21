package pe.edu.idat.appwebtickets.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.appwebtickets.model.bd.Area;
import pe.edu.idat.appwebtickets.repository.AreaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AreaService {
    private AreaRepository areaRepository;

    public List<Area> listarAreas(){
        return areaRepository.findAll();
    }
}
