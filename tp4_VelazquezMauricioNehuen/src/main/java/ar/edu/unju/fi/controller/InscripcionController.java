package ar.edu.unju.fi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.service.IMateriaService;

@Controller
@RequestMapping("/inscripcion")
public class InscripcionController {
	
	@Autowired
    private AlumnoDTO alumnoDTO;
	//CONSULTAR LOGICAAAAA
	@Qualifier("materiaServiceMySql")
    @Autowired
    private IMateriaService materiaService;
	
	@Qualifier("alumnoServiceMySql")
	@Autowired
	private IAlumnoService alumnoService;
	
	@GetMapping("/carreras")
    public String formInscripciones(Model model) {
		model.addAttribute("materias", materiaService.findByEstado(true));
        model.addAttribute("titulo", "Inscripciones");
        model.addAttribute("alumno", alumnoDTO);
        return "inscripcionAlumno";
    }
	
	@PostMapping("/inscribir")
	public String editarAlumno(@ModelAttribute("alumno") AlumnoDTO alumnoDTO, @RequestParam("MateriaID") Long materiaId, RedirectAttributes redirectAttributes) {
		List<AlumnoDTO> alumnos = alumnoService.findByEstado(true);
		for (AlumnoDTO a : alumnos) {
            if (a.getLu().equals(alumnoDTO.getLu())) {
            	//alumnoDTO = a;
            	MateriaDTO materiaDTO = materiaService.findById(materiaId);
            	if(a.getMaterias().isEmpty()) {
            		List<MateriaDTO> materiasDTO = new ArrayList<>();
            		materiasDTO.add(materiaDTO);
            		a.setMaterias(materiasDTO);
            	}else {
            		a.getMaterias().add(materiaDTO);
            	}          	
            alumnoService.edit(a);
            redirectAttributes.addFlashAttribute("isUpdated", true);
            redirectAttributes.addFlashAttribute("isNotUpdated", false);
            System.out.println("ENCONTRADO");
            break;
            }else {
            	redirectAttributes.addFlashAttribute("isUpdated", false);
            	redirectAttributes.addFlashAttribute("isNotUpdated", true);
            	System.out.println("NO ENCONTRADO");
            }
		}
	    return "redirect:/inscripcion/carreras";
	}
	
}
