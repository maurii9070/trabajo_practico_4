package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.service.ICarreraService;
import ar.edu.unju.fi.service.IMateriaService;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {
	
	@Qualifier("materiaServiceMySql")
    @Autowired
    private IMateriaService materiaService;
	
	@Qualifier("carreraServiceMySql")
    @Autowired
    private ICarreraService carreraService;
	
	@Qualifier("alumnoServiceMySql")
    @Autowired
    private IAlumnoService alumnoService;
	
	@GetMapping("/alumnos")
    public String formInscripciones(Model model) {
		model.addAttribute("materias", materiaService.findAll());
		model.addAttribute("carreras",  carreraService.findByEstado(true));
        model.addAttribute("titulo", "Consultas");
        model.addAttribute("nombre", false);
        model.addAttribute("texto","");
        return "consultas";
    }
	
	/*
	 * @GetMapping("/carrera") public String listaAlumnosCarr (Model
	 * model, @PathVariable(value = "id") Long id) { List<AlumnoDTO>
	 * alumnosPorCarrera = new ArrayList<>(); alumnosPorCarrera =
	 * carreraService.findById(id).getAlumnos(); model.addAttribute("alumnos",
	 * alumnosPorCarrera); model.addAttribute("titulo", "Alumnos"); return
	 * "consultas"; }
	 * 
	 * @GetMapping("/materia") public String listaAlumnosMat (Model
	 * model, @PathVariable(value = "id") Long id) { List<AlumnoDTO>
	 * alumnosPorMateria = new ArrayList<>(); alumnosPorMateria =
	 * materiaService.findById(id).getAlumnos(); model.addAttribute("alumnos",
	 * alumnosPorMateria); model.addAttribute("titulo", "Alumnos"); return
	 * "consultas"; }
	 */
	
	@GetMapping("/carrera/{id}") 
	public String listaAlumnosCarr (Model model, @PathVariable(value = "id") Long id) {
		
		model.addAttribute("materias", materiaService.findAll());
		model.addAttribute("carreras",  carreraService.findByEstado(true));
		model.addAttribute("alumnos", alumnoService.findByCarrera(id));
		model.addAttribute("titulo", "Alumnos");
		model.addAttribute("nombre", true);
		model.addAttribute("texto", "Carrera: "+ carreraService.findById(id).getNombre());
		return "consultas";
	}
	
	@GetMapping("/materia/{id}")
	public String listaAlumnosMateria (Model model, @PathVariable(value = "id") Long id) {
		model.addAttribute("materias", materiaService.findAll());
		model.addAttribute("carreras", carreraService.findByEstado(true));
		model.addAttribute("alumnos", alumnoService.findByMateria(id));
		model.addAttribute("titulo", "Alumnos");
		model.addAttribute("nombre", true);
		model.addAttribute("texto", "Materia: "+ materiaService.findById(id).getNombre());
		return "consultas";
	}
}
