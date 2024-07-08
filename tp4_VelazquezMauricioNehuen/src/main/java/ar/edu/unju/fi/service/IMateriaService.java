package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.MateriaDTO;

public interface IMateriaService {
	List<MateriaDTO> findAll();
	
	MateriaDTO findById(String codigo);
	
	boolean save(MateriaDTO materiaDTO);
	
	void deleteById(String codigo);
	
	void edit(MateriaDTO materiaDTO);
	
	List<MateriaDTO> findByAlumno(Long id);
	
	List<MateriaDTO> findByEstado(boolean estado);
}
