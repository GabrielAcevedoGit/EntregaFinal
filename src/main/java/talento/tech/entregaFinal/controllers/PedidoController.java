package talento.tech.entregaFinal.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import talento.tech.entregaFinal.Exceptions.ProductoInvalidoException;
import talento.tech.entregaFinal.Exceptions.RecursoNoEncontradoException;
import talento.tech.entregaFinal.Exceptions.StockInsuficienteException;
import talento.tech.entregaFinal.dtos.PedidoDTO;
import talento.tech.entregaFinal.models.pedidos.Pedido;
import talento.tech.entregaFinal.services.IPedidosService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    private final IPedidosService pedidoService;

    public PedidoController(IPedidosService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<?> crearPedido(@Valid @RequestBody PedidoDTO dto) {
        try {
            Pedido nuevoPedido = pedidoService.crearPedido(dto);
            return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);

        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(crearMapaError(e.getMessage()));

        } catch (StockInsuficienteException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(crearMapaError(e.getMessage()));

        } catch (ProductoInvalidoException | IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(crearMapaError(e.getMessage()));

        } catch (Exception e) {
            // Esto atrapa errores de validación (@Valid) si no hay un GlobalHandler
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(crearMapaError("Error: " + e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obtenerPedido(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.obtenerPedido(id));
    }

    private Map<String, String> crearMapaError(String mensaje) {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("error", mensaje);
        return mapa;
    }
}