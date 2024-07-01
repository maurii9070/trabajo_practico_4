package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.IAlumnoService;

@Service ("alumnoServiceMySql")
public class AlumnoServiceImp implements IAlumnoService {
	 @Autowired
	 private AlumnoRepository alumnoRepository;
	 @Autowired 
	 private AlumnoMapper alumnoMapper;

	@Override
	public List<AlumnoDTO> findAll() {
		// TODO Auto-generated method stub
		return alumnoMapper.toAlumnoDTOList(alumnoRepository.findAll());
	}

	@Override
	public AlumnoDTO findById(UUID id) {
		return alumnoMapper.toAlumnoDTO(alumnoRepository.findById(id).get());
	}

	@Override
	public Alumno save(AlumnoDTO alumnoDTO) {
		return alumnoRepository.save(alumnoMapper.toAlumno(alumnoDTO));
	}

	@Override
	public void deleteById(UUID id) {
		Alumno alumno = alumnoRepository.findById(id).get();
		alumno.setEstado(false);
		alumnoRepository.save(alumno);
		
	}

	@Override
	public void edit(AlumnoDTO alumnoDTO) {
		alumnoRepository.save(alumnoMapper.toAlumno(alumnoDTO));
		
	}

}
