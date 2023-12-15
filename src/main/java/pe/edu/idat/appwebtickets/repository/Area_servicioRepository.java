package pe.edu.idat.appwebtickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.appwebtickets.model.bd.Area_servicio;

@Repository
public interface Area_servicioRepository extends JpaRepository<Area_servicio,Integer> {
}
