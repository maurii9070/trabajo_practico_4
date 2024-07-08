package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.CarreraDTO;

public interface ICarreraService {
	
	List<CarreraDTO> findAll();
	
	CarreraDTO findById(String codigo);
	
	boolean save(CarreraDTO carreraDTO);
	
	void deleteById(String codigo);
	 
	void edit(CarreraDTO carreraDTO);

}
