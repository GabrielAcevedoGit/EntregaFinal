package talento.tech.entregaFinal.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductoDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @Positive(message = "El precio debe ser mayor a 0")
    private double price;

    @NotNull
    @Min(value = 1, message = "Tiene que tener stock disponible para publicarlo")
    private int stock;

    private String image;
}