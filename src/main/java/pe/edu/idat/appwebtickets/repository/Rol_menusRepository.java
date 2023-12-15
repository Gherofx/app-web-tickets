package pe.edu.idat.appwebtickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.appwebtickets.model.bd.Rol_menus;

@Repository
public interface Rol_menusRepository extends JpaRepository<Rol_menus,Integer> {
}
