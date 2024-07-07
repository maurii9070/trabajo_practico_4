package ar.edu.unju.fi.dto;


import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Materia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DocenteDTO {
	
	private Long idDocente;
	private String legajo;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private boolean estado;
    
    private Long materiaId; // Campo para almacenar el ID de la materia
    private Materia materia;
}
