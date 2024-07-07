package ar.edu.unju.fi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CarreraDTO {
    private String codigo;
    private String nombre;
    private Byte cantidadAnios;
    private Boolean estado;
}
