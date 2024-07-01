package ar.edu.unju.fi;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.service.IAlumnoService;

@SpringBootTest
class EditAlumno {

	@Autowired
    private AlumnoMapper alumnoMapper;
	
	@Qualifier("alumnoServiceMySql")
    @Autowired
    private IAlumnoService alumnoService;
	
	@Test
	void editAlumno() {
		UUID id = UUID.fromString("35c18f2d-4b38-48f9-acd3-1d6f5e13b1ad");
		Alumno alumno= new Alumno(UUID.randomUUID(),"40565353", "Nehuen", "Velazquezzzzzzzzzzz", "mauricio@correo.com", "388412345",
                LocalDate.of(1996, 10, 29), "Av. San Martin 123", "APU4853",true, null, null);
		alumno.setIdAlumno(id);
		
		alumnoService.edit(alumnoMapper.toAlumnoDTO(alumno));
		
	}

}
