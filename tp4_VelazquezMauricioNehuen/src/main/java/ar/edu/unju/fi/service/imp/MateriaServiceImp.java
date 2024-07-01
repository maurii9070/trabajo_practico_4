package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.IMateriaService;

@Service("materiaServiceMySql")
public class MateriaServiceImp implements IMateriaService {

	@Autowired
	 private MateriaRepository materiaRepository;
	 @Autowired 
	 private MateriaMapper materiaMapper;
	
	@Override
	public List<MateriaDTO> findAll() {
		return materiaMapper.toMateriaDTOList(materiaRepository.findAll());
	}

	@Override
	public MateriaDTO findById(Long id) {
		return materiaMapper.toMateriaDTO(materiaRepository.findById(id).get());
		
	}

	@Override
	public Materia save(MateriaDTO materiaDTO) {
		return materiaRepository.save(materiaMapper.toMateria(materiaDTO));
		
	}

	@Override
	public void deleteById(Long id) {
		Materia materia = materiaRepository.findById(id).get();
		materia.setEstado(false);
		materiaRepository.save(materia);
		
	}

	@Override
	public void edit(MateriaDTO materiaDTO) {
		materiaRepository.save(materiaMapper.toMateria(materiaDTO));
		
	}

}
