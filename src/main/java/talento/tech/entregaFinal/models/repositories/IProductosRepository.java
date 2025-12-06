package talento.tech.entregaFinal.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import talento.tech.entregaFinal.models.productos.Producto;

import java.util.List;

@Repository
public interface IProductosRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNameContainingIgnoreCase(String name);
}

