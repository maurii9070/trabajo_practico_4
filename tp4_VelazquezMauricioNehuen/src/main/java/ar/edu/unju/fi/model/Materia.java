package ar.edu.unju.fi.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Materia {
    private String nombre;
    private String codigo;
    private String curso;
    private Byte cantidadHoras;
    private String modalidad;
    private Docente docente;
    private Carrera carrera;
}
