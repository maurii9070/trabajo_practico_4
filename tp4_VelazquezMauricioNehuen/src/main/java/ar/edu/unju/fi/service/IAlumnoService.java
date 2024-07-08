package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.AlumnoDTO;

public interface IAlumnoService {

	List<AlumnoDTO> findAll();
	
	AlumnoDTO findById(String dni);
	
	// Posible cambio a boolean
	boolean save(AlumnoDTO alumnoDTO);
	
	void deleteById(String dni);
	
	void edit(AlumnoDTO alumnoDTO);
}
