package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.IDocenteService;

@Service("docenteServiceMySql")
public class DocenteServiceImp implements IDocenteService {
	
	 @Autowired
	 private DocenteRepository docenteRepository;
	 @Autowired 
	 private DocenteMapper docenteMapper;
	 
	 //se inyects materia
	 
	 @Autowired
	    private MateriaRepository materiaRepository;

	@Override
	public List<DocenteDTO> findAll() {
		return docenteMapper.toDocenteDTOList(docenteRepository.findAll());
		
	}

	@Override
	public DocenteDTO findById(Long id) {
		return docenteMapper.toDocenteDTO(docenteRepository.findById(id).get());
		
	}

	@Override
	public Docente save(DocenteDTO docenteDTO) {
		return docenteRepository.save(docenteMapper.toDocente(docenteDTO));
	}

	@Override
	public void deleteById(Long id) {
		Docente docente = docenteRepository.findById(id).get();
		docente.setEstado(false);
		docenteRepository.save(docente);
		
	}

	@Override
	public void edit(DocenteDTO docenteDTO) {
		Docente docente=docenteRepository.save(docenteMapper.toDocente(docenteDTO));
		
	}
	
	

	@Override
	public List<DocenteDTO> findDocentesSinMateria() {
		return docenteMapper.toDocenteDTOList(docenteRepository.findDocentesSinMateria());
	}

	@Override
	public List<DocenteDTO> findByEstado(boolean estado) {
		List<DocenteDTO> docentesDtos = docenteMapper.toDocenteDTOList(docenteRepository.findByEstado(estado));
		return docentesDtos;
	}

}
