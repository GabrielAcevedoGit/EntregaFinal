package talento.tech.entregaFinal.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PedidoDTO {
    private List<LineaPedidoDTO> items;
}