package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.dto.CarreraDTO;

import ar.edu.unju.fi.service.imp.CarreraServiceImp;

@Controller

@RequestMapping("/carreras-sql")

public class CarreraControllerSql {
	
	@Autowired
	private CarreraDTO carreraDTO;
	
	@Qualifier("carreraServiceMySql")
	@Autowired
	private CarreraServiceImp carreraServiceImp;
	
	 @GetMapping("/listado")
	    public String getCarrerasPage(Model model) {
	        model.addAttribute("titulo", "Carreras");
	        model.addAttribute("carreras", carreraServiceImp.findAll());
	        return "carreras-sql";
	    }
	 
	 
	 @GetMapping("/nueva-carrera")
	    public String getNuevaCarreraPage(Model model) {
	        boolean edicion = false;
	        model.addAttribute("titulo", "Carreras");
	        model.addAttribute("edicion", edicion);
	        model.addAttribute("carrera", carreraDTO);
	        return "carrera-form";
	    }
	 
	 
	 @PostMapping("/guardar-carrera")
	    public ModelAndView guardarCarrera(@ModelAttribute("carrera") CarreraDTO carreraDTO) {
	        ModelAndView modelView = new ModelAndView("carreras");
	        carreraDTO.setIdCarrera((long) 30);
	        carreraDTO.setEstado(true);
	        carreraServiceImp.save(carreraDTO);
	        modelView.addObject("carreras", carreraServiceImp.findAll());
	        modelView.addObject("isAdded", true);
	        return modelView;
	    }
	 
	 
	 @GetMapping("/editar-carrera/{id}")
	    public String getEditarCarreraPage(Model model, @PathVariable(value = "id") Long id) {
	        boolean edicion = true;
	        CarreraDTO carreraEncontrada = new CarreraDTO() ;
	        carreraEncontrada = carreraServiceImp.findById(id);
	        model.addAttribute("titulo", "Carreras");
	        model.addAttribute("edicion", edicion);
	        model.addAttribute("carrera", carreraEncontrada);
	        return "carrera-form";
	    }
	 
	 
	 @PostMapping("/modificar-carrera")
	    public String editarCarrera(@ModelAttribute("carrera") CarreraDTO carreraDTO, RedirectAttributes redirectAttributes) {
	        carreraServiceImp.edit(carreraDTO);
	        redirectAttributes.addFlashAttribute("isUpdated", true);
	        return "redirect:/carreras-sql/listado";
	    }
	 
	 
	 @GetMapping("/eliminar-carrera/{id}")
	    public String eliminarCarrera(@PathVariable(value = "id") Long id) {
	        carreraServiceImp.deleteById(id);
	        return "redirect:/carreras-sql/listado";
	    }
	

}
