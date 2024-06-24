package ar.edu.unju.fi.mapper;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.model.Alumno;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarreraMapper {

    CarreraDTO toCarreraDTO(Alumno alumno);

    Alumno toCarrera(CarreraDTO carreraDTO);

    List<CarreraDTO> toCarreraDTOList (List<Alumno> alumnos);

    List<Alumno> toCarreraList (List<CarreraDTO> alumnosDTO);
}
