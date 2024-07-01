package ar.edu.unju.fi.service;

import java.util.List;
import java.util.UUID;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.model.Materia;

public interface IMateriaService {
	List<MateriaDTO> findAll();
	
	MateriaDTO findById(UUID id);
	
	Materia save(MateriaDTO materiaDTO);
	
	void deleteById(UUID id);
	
	void edit(MateriaDTO materiaDTO);
}
