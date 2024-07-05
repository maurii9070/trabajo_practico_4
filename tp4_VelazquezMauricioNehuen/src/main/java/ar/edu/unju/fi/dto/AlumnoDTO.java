package ar.edu.unju.fi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDTO {

	private Long idAlumno;
    private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String fechaNacimiento;
    private String domicilio;
    private String lu;
    private boolean estado;
    
    private Long carreraId; // Nuevo campo para almacenar el ID de la carrera asociada
    
    private Carrera carrera; // Nuevo campo para almacenar la entidad de la carrera asociada
}
