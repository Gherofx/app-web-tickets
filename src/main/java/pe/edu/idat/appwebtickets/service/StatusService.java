package pe.edu.idat.appwebtickets.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.appwebtickets.model.bd.Status;
import pe.edu.idat.appwebtickets.repository.StatusRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StatusService {
    private StatusRepository statusRepository;

    public List<Status> listarStatus(){
        return statusRepository.findAll();
    }
}
