package pe.edu.idat.appwebtickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.appwebtickets.model.bd.Ticket_estado;

@Repository
public interface Ticket_estadoRepository extends JpaRepository<Ticket_estado,Integer> {
}
