package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.mapper.CarreraMapper;
import ar.edu.unju.fi.service.ICarreraService;


@Service

public class CarreraServiceImpl implements ICarreraService {
	
	@Autowired
	private CarreraMapper carreraMapper;

	@Override
	public List<CarreraDTO> findAll() {
		// TODO Auto-generated method stub
		
		List<CarreraDTO> carrerasDtos = carreraMapper.toCarreraDTOList(CollectionCarrera.getCarreras());
		
		return carrerasDtos;
	}

	@Override
	public CarreraDTO findById(String codigo) {
		// TODO Auto-generated method stub
		
		CarreraDTO carreraDTO = carreraMapper.toCarreraDTO(CollectionCarrera.buscarCarrera(codigo));
		
		return carreraDTO;
	}

	@Override
	public boolean save(CarreraDTO carreraDTO) {
		// TODO Auto-generated method stub
		
		boolean respuesta = CollectionCarrera.agregarCarrera(carreraMapper.toCarrera(carreraDTO));
		
		return respuesta;
	}

	@Override
	public void deleteById(String codigo) {
		// TODO Auto-generated method stub
		
		CollectionCarrera.eliminarCarerra(codigo);

	}

	@Override
	public void edit(CarreraDTO carreraDTO) {
		// TODO Auto-generated method stub
		
		CollectionCarrera.modificarCarrera(carreraMapper.toCarrera(carreraDTO));

	}

}
