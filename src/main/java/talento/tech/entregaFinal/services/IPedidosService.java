package talento.tech.entregaFinal.services;

import talento.tech.entregaFinal.dtos.PedidoDTO;
import talento.tech.entregaFinal.models.pedidos.Pedido;


public interface IPedidosService {
    Pedido crearPedido(PedidoDTO pedidoDto);
    Pedido obtenerPedido(Long id);
}
