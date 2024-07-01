package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.service.IDocenteService;

@Service("docenteServiceCollection")
public class DocenteServiceImpl implements IDocenteService {
	
	@Autowired
	private DocenteMapper docenteMapper;

	@Override
	public List<DocenteDTO> findAll() {
		
		List<DocenteDTO> docenteDTO = docenteMapper.toDocenteDTOList(CollectionDocente.getDocentes());
		
		return docenteDTO;
	}

	@Override
	public DocenteDTO findById(UUID id) {
		DocenteDTO docenteDTO = docenteMapper.toDocenteDTO(CollectionDocente.buscarDocente(id.toString()));
		return docenteDTO;
	}

	@Override
	public Docente save(DocenteDTO docenteDTO) {
		CollectionDocente.agregarDocente(docenteMapper.toDocente(docenteDTO));
		return CollectionDocente.buscarDocente(docenteDTO.getIdDocente().toString());
	}

	@Override
	public void deleteById(UUID id) {
		
		CollectionDocente.eliminarDocente(id.toString());

	}

	@Override
	public void edit(DocenteDTO docenteDTO) {
		
		CollectionDocente.modificarDocente(docenteMapper.toDocente(docenteDTO));

	}

}
