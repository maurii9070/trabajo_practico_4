package ar.edu.unju.fi.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Carrera {
    private String codigo;
    private String nombre;
    private Byte cantidadAnios;
    private Boolean estado;

}
