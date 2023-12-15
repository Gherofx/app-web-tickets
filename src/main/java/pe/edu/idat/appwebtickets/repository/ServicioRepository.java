package pe.edu.idat.appwebtickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.appwebtickets.model.bd.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio,Integer> {
}
