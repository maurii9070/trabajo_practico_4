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
class FindAlumno {

	@Autowired
    private AlumnoMapper alumnoMapper;
	
	@Qualifier("alumnoServiceMySql")
    @Autowired
    private IAlumnoService alumnoService;
	
	@Test
	void findAlumnos() {
		System.out.println(alumnoService.findAll());
	}

}
