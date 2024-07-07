package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.collections.CollectionAlumno;
import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.service.IAlumnoService;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

	@Autowired
	private AlumnoMapper alumnoMapper;
	
	@Override
	public List<AlumnoDTO> findAll() {
		List<AlumnoDTO> alumnosDTO = alumnoMapper.toAlumnoDTOList(CollectionAlumno.getAlumnos());
		return alumnosDTO;
	}

	@Override
	public AlumnoDTO findById(String dni) {
		AlumnoDTO alumnoDTO = alumnoMapper.toAlumnoDTO(CollectionAlumno.buscarAlumno(dni));
		return alumnoDTO;
	}

	@Override
	public boolean save(AlumnoDTO alumnoDTO) {
		boolean respuesta = CollectionAlumno.agregarAlumno(alumnoMapper.toAlumno(alumnoDTO));
		return respuesta;
	}

	@Override
	public void deleteById(String dni) {
		CollectionAlumno.eliminarAlumno(dni);
		
	}

	@Override
	public void edit(AlumnoDTO alumnoDTO) {
		CollectionAlumno.modificarAlumno(alumnoMapper.toAlumno(alumnoDTO));
		
	}

}
