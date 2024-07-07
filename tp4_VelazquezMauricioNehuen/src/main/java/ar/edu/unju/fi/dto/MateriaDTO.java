package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MateriaDTO {
	
	private Long idMateria;
	private String nombre;
    private String codigo;
    private String curso;
    private Byte cantidadHoras;
    private String modalidad;
    private boolean estado;
    private Docente docente;
    private Carrera carrera;
}
