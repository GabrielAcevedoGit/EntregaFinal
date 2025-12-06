package talento.tech.entregaFinal.services;

import talento.tech.entregaFinal.dtos.ProductoDTO;
import talento.tech.entregaFinal.models.productos.Producto;

import java.util.List;

public interface IProductosService {
    Producto crearProducto(ProductoDTO productoDto);
    Producto actualizarProducto(Long id, ProductoDTO productoDto);
    Producto obtenerProducto(Long id);
    List<Producto> listarProductos();
    void eliminarProducto(Long id);
}