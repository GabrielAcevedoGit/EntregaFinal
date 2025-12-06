package talento.tech.entregaFinal.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talento.tech.entregaFinal.Exceptions.RecursoNoEncontradoException;
import talento.tech.entregaFinal.dtos.ProductoDTO;
import talento.tech.entregaFinal.models.productos.Producto;
import talento.tech.entregaFinal.models.repositories.IProductosRepository;
import talento.tech.entregaFinal.services.IProductosService;

import java.util.List;

@Service
public class ProductosService implements IProductosService {
    private final IProductosRepository productoRepository;

    public ProductosService(IProductosRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional
    public Producto crearProducto(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setName(dto.getName());
        producto.setPrice(dto.getPrice());
        producto.setStock(dto.getStock());
        producto.setImage(dto.getImage());

        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public Producto actualizarProducto(Long id, ProductoDTO dto) {
        Producto producto = productoRepository.findById(id)
                // CORREGIDO: Usar excepción propia
                .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado con ID: " + id));

        producto.setName(dto.getName());
        producto.setPrice(dto.getPrice());
        producto.setStock(dto.getStock());
        producto.setImage(dto.getImage());

        return productoRepository.save(producto);
    }

    @Override
    public Producto obtenerProducto(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado"));
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}

