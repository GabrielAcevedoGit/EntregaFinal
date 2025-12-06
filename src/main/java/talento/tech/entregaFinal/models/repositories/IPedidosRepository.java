package talento.tech.entregaFinal.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import talento.tech.entregaFinal.models.pedidos.Pedido;

@Repository
public interface IPedidosRepository extends JpaRepository<Pedido, Long> {
}
