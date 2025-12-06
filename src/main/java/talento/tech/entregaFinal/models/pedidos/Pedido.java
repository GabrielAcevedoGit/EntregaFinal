package talento.tech.entregaFinal.models.pedidos;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import talento.tech.entregaFinal.models.productos.Producto;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<LineaPedido> lineas = new ArrayList<>();

    @Column(name = "total")
    private double total = 0.0;

    public void agregarLinea(Producto producto, int cantidad) {
        LineaPedido linea = new LineaPedido();
        linea.setProducto(producto);
        linea.setCantidad(cantidad);
        linea.setSubtotal(producto.getPrice() * cantidad);
        linea.setPedido(this);

        this.lineas.add(linea);
        this.total += linea.getSubtotal();
    }
}