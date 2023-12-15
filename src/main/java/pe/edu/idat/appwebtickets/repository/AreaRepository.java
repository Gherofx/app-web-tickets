package pe.edu.idat.appwebtickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.appwebtickets.model.bd.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area,Integer> {
}
