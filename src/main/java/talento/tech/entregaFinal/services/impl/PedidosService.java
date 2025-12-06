package talento.tech.entregaFinal.services.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talento.tech.entregaFinal.Exceptions.ProductoInvalidoException;
import talento.tech.entregaFinal.Exceptions.RecursoNoEncontradoException;
import talento.tech.entregaFinal.Exceptions.StockInsuficienteException;
import talento.tech.entregaFinal.dtos.LineaPedidoDTO;
import talento.tech.entregaFinal.dtos.PedidoDTO;
import talento.tech.entregaFinal.models.pedidos.Pedido;
import talento.tech.entregaFinal.models.productos.Producto;
import talento.tech.entregaFinal.models.repositories.IPedidosRepository;
import talento.tech.entregaFinal.models.repositories.IProductosRepository;
import talento.tech.entregaFinal.services.IPedidosService;

@Service
public class PedidosService implements IPedidosService {
    private final IPedidosRepository pedidoRepository;
    private final IProductosRepository productoRepository;

    public PedidosService(IPedidosRepository pedidoRepository, IProductosRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional
    public Pedido crearPedido(PedidoDTO dto) {
        Pedido pedido = new Pedido();

        if (dto.getItems() == null || dto.getItems().isEmpty()) {
            throw new IllegalArgumentException("El pedido no puede estar vacío");
        }

        for (LineaPedidoDTO item : dto.getItems()) {
            if (item.getCantidad() <= 0) {
                throw new IllegalArgumentException("La cantidad debe ser mayor a 0 para el producto ID: " + item.getProductoId());
            }

            Producto producto = productoRepository.findById(item.getProductoId())
                    .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado ID: " + item.getProductoId()));

            if (!producto.isActivo()) {
                throw new ProductoInvalidoException("El producto '" + producto.getName() + "' está descatalogado y no se puede vender.");
            }

            if (producto.getStock() < item.getCantidad()) {
                throw new StockInsuficienteException("No hay suficiente stock para: " + producto.getName());
            }

            producto.setStock(producto.getStock() - item.getCantidad());
            productoRepository.save(producto);
            pedido.agregarLinea(producto, item.getCantidad());
        }

        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido obtenerPedido(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Pedido no encontrado"));
    }

}
