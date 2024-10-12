package pe.edu.cibertec.springsecurityt2daw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.springsecurityt2daw.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
