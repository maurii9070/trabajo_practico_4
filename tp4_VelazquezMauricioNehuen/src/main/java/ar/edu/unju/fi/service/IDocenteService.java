package ar.edu.unju.fi.service;

import java.util.List;
import java.util.UUID;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.model.Docente;

public interface IDocenteService {
	
	List<DocenteDTO> findAll();
	
	DocenteDTO findById(UUID id);
	
	Docente save(DocenteDTO docenteDTO);
	
	void deleteById(UUID id);
	
	void edit(DocenteDTO docenteDTO);

}
