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
		//return docenteMapper.toDocenteDTOList(docenteRepository.findAll());
		List<Docente> docentes = docenteRepository.findAll();
        return docentes.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public DocenteDTO findById(Long id) {
		//return docenteMapper.toDocenteDTO(docenteRepository.findById(id).get());
		Docente docente = docenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Docente no encontrado"));
        return convertToDTO(docente);
	}

	@Override
	public Docente save(DocenteDTO docenteDTO) {
		//return docenteRepository.save(docenteMapper.toDocente(docenteDTO));
		// se hacen modificaciones para asegurar el mapeo de docenteDTO
		Docente docente = docenteMapper.toDocente(docenteDTO);
		
		 // Validar que el ID de la materia no sea nulo
	    if (docenteDTO.getMateriaId() != null) {
	        Materia materia = materiaRepository.findById(docenteDTO.getMateriaId()).orElse(null);
	        docente.setMateria(materia);
	    } else {
	        docente.setMateria(null);
	    }

	    return docenteRepository.save(docente);
		
	}

	@Override
	public void deleteById(Long id) {
		//Docente docente = docenteRepository.findById(id).get();
		Docente docente = docenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Docente no encontrado"));
		docente.setEstado(false);
		docenteRepository.save(docente);
		
	}

	@Override
	public void edit(DocenteDTO docenteDTO) {
		//docenteRepository.save(docenteMapper.toDocente(docenteDTO));
		
		Docente docente = docenteMapper.toDocente(docenteDTO);
        Materia materia = materiaRepository.findById(docenteDTO.getMateria().getIdMateria()).orElse(null);
        docente.setMateria(materia);
        docente.setMateria(materia);
        if (docente.getIdDocente() == null) {
            throw new RuntimeException("El ID del docente no puede ser nulo");
        }
        if (docenteRepository.existsById(docente.getIdDocente())) {
            docenteRepository.save(docente);
        } else {
            throw new RuntimeException("Docente no encontrado");
        }
		
	}
	
	private DocenteDTO convertToDTO(Docente docente) {
        return docenteMapper.toDocenteDTO(docente);
    }

}
