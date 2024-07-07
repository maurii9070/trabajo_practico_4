package ar.edu.unju.fi.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Docente {
    private String legajo;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
