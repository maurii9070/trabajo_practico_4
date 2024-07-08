package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.service.IDocenteService;

@Service

public class DocenteServiceImpl implements IDocenteService {
	
	@Autowired
	private DocenteMapper docenteMapper;

	@Override
	public List<DocenteDTO> findAll() {
		
		List<DocenteDTO> docenteDTO = docenteMapper.toDocenteDTOList(CollectionDocente.getDocentes());
		
		return docenteDTO;
	}

	@Override
	public DocenteDTO findById(String legajo) {
		
		DocenteDTO docenteDTO = docenteMapper.toDocenteDTO(CollectionDocente.buscarDocente(legajo));
		
		return docenteDTO;
	}

	@Override
	public boolean save(DocenteDTO docenteDTO) {
		
		boolean respuesta = CollectionDocente.agregarDocente(docenteMapper.toDocente(docenteDTO));
		
		return respuesta;
	}

	@Override
	public void deleteById(String legajo) {
		
		CollectionDocente.eliminarDocente(legajo);

	}

	@Override
	public void edit(DocenteDTO docenteDTO) {
		
		CollectionDocente.modificarDocente(docenteMapper.toDocente(docenteDTO));

	}

	@Override
	public List<DocenteDTO> findDocentesSinMateria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DocenteDTO> findByEstado(boolean estado) {
		// TODO Auto-generated method stub
		return null;
	}

}
