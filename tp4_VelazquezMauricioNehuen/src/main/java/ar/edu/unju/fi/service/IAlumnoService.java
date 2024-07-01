package ar.edu.unju.fi.service;

import java.util.List;
import java.util.UUID;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;

public interface IAlumnoService {

	List<AlumnoDTO> findAll();
	
	AlumnoDTO findById(UUID id);
	
	// Posible cambio a boolean
	Alumno save(AlumnoDTO alumnoDTO);
	
	void deleteById(UUID id);
	
	void edit(AlumnoDTO alumnoDTO);
}
