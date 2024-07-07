package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.mapper.CarreraMapper;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.ICarreraService;

@Service("carreraServiceMySql")
public class CarreraServiceImp implements ICarreraService {

	@Autowired
	private CarreraMapper carreraMapper;
	
	@Autowired
	private CarreraRepository carreraRepository;

	@Override
	public List<CarreraDTO> findAll() {
		List<CarreraDTO> carrerasDtos = carreraMapper.toCarreraDTOList(carreraRepository.findAll());
		
		return carrerasDtos;
	}

	/* @Override
	public CarreraDTO findById(Long id) {
		CarreraDTO carreraDTO = carreraMapper.toCarreraDTO(carreraRepository.findById(id).get());
		return carreraDTO;
	}
	
	*/
	
	@Override
    public CarreraDTO findById(Long id) {
        Carrera carrera = carreraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
        return carreraMapper.toCarreraDTO(carrera);
    }
	
	
	@Override
	public Carrera save(CarreraDTO carreraDTO) {
		return carreraRepository.save(carreraMapper.toCarrera(carreraDTO));
	}


	/*
	@Override
	public void edit(CarreraDTO carreraDTO) {
		carreraRepository.save(carreraMapper.toCarrera(carreraDTO));

	}
	*/
	
	// pruebaaaaaaa
	
	@Override
	public void edit(CarreraDTO carreraDTO) {
	    Carrera carrera = carreraMapper.toCarrera(carreraDTO);
	    if (carrera.getIdCarrera() == null) {
	        throw new RuntimeException("El ID de la carrera no puede ser nulo");
	    }
	    if (carreraRepository.existsById(carrera.getIdCarrera())) {
	        carreraRepository.save(carrera);
	    } else {
	        throw new RuntimeException("Carrera no encontrada");
	    }
	}


	/* @Override
	public void deleteById(Long id) {
		Carrera carrera = carreraRepository.findById(id).get();
		carrera.setEstado(false);
		carreraRepository.save(carrera);
		
	}
	
	*/
	
	@Override
    public void deleteById(Long id) {
        Carrera carrera = carreraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
        carrera.setEstado(false); 
        carreraRepository.save(carrera);
    }
	
}
