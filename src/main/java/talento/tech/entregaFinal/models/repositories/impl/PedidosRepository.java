package talento.tech.entregaFinal.models.repositories.impl;



import talento.tech.entregaFinal.models.pedidos.Pedido;

import java.util.ArrayList;
import java.util.List;
// ESTO QUEDA SIN USO PORQUE AHORA LA INTERFAZ SE ENCARGA DE GUARDAR
public class PedidosRepository {
    List<Pedido> pedidos = new ArrayList<>();

    public void save(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> findAll() {
        return pedidos;
    }
}
