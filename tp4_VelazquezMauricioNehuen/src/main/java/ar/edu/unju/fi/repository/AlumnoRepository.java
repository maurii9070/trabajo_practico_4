package ar.edu.unju.fi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
	
	@Query(value = "SELECT * FROM alumnos WHERE car_id = ?1", nativeQuery = true)
    List<Alumno> findByCarrera(Long id);
	
	@Query(value = "SELECT * FROM alumnos WHERE alu_estado = ?1", nativeQuery = true)
    List<Alumno> findByEstado(boolean estado);
	
    @Query(value = "SELECT a.*\r\n"
    		+ "FROM alumnos a\r\n"
    		+ "JOIN alumnos_materias am ON a.alu_id = am.alu_id\r\n"
    		+ "JOIN materias m ON am.mat_id = m.mat_id\r\n"
    		+ "WHERE m.mat_id = ?;", nativeQuery = true)
    List<Alumno> findByMateria(Long id);
}
