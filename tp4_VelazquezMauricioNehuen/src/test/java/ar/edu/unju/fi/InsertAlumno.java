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
class InsertAlumno {

	@Autowired
    private AlumnoMapper alumnoMapper;
	
	@Qualifier("alumnoServiceMySql")
    @Autowired
    private IAlumnoService alumnoService;
	
	@Test
	void guardarAlumno() {
		Alumno alumno= new Alumno(UUID.randomUUID(),"40565353", "Mauricio", "Velazquez", "mauricio@correo.com", "388412345",
                LocalDate.of(1996, 10, 29), "Av. San Martin 123", "APU4853",true, null, null);
		alumnoService.save(alumnoMapper.toAlumnoDTO(alumno));
	}

}
