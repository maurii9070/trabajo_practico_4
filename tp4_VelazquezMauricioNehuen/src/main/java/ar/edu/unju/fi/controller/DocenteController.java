package ar.edu.unju.fi.controller;



import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.service.IDocenteService;
import ar.edu.unju.fi.service.IMateriaService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/docentes")
public class DocenteController {
    @Autowired
    private DocenteDTO docenteDTO;
    
    
    @Qualifier("docenteServiceMySql")
    @Autowired
    private IDocenteService docenteService;
    
    @Qualifier("materiaServiceMySql")
    @Autowired
    private IMateriaService materiaService;
    

    /**
     * Metodo que permite mostrar la pagina de docentes
     *
     * @param model objeto que permite agregar atributos y enviarlos a la vista
     * @return la vista docentes.html
     */
    @GetMapping("/listado")
    public String getDocentesPage(Model model) {
        model.addAttribute("titulo", "Docentes");
        model.addAttribute("docentes", docenteService.findAll());
        return "docentes";
    }

    /**
     * Metodo que permite mostrar la pagina de nuevo docente
     *
     * @param model objeto que permite agregar atributos y enviarlos a la vista
     * @return la vista docente-form.html
     */
    @GetMapping("/nuevo-docente")
    public String getNuevoDocentePage(Model model) {
        boolean edicion = false;
        model.addAttribute("titulo", "Docentes");
        model.addAttribute("edicion", edicion);
        model.addAttribute("docente", docenteDTO);
        //se agrega materia
        model.addAttribute("materias", materiaService.findAll());
        return "docente-form";
    }

    /**
     * Metodo que permite guardar un nuevo docente
     *
     * @param docenteDTO objeto que representa un docente
     * @return la vista docentes.html
     */
    @PostMapping("/guardar-docente")
    public ModelAndView guardarDocente(@ModelAttribute("carrera") DocenteDTO docenteDTO) {
        ModelAndView modelView = new ModelAndView("docentes");
        docenteDTO.setEstado(true);
        
        
        docenteService.save(docenteDTO);
        modelView.addObject("docentes", docenteService.findAll());
        modelView.addObject("titulo", "Docentes");
        modelView.addObject("isAdded", true);
        return modelView;
    }

    /**
     * Metodo que permite mostrar la pagina de editar docente
     *
     * @param model  objeto que permite agregar atributos y enviarlos a la vista
     * @param id legajo del docente a editar
     * @return la vista docente-form.html
     */
    @GetMapping("/editar-docente/{id}")
    public String getEditarDocentePage(Model model, @PathVariable(value = "id") Long id) {
        boolean edicion = true;
        DocenteDTO docenteEncontrado = new DocenteDTO();
        docenteEncontrado = docenteService.findById(id);
        model.addAttribute("titulo", "Docentes");
        model.addAttribute("edicion", edicion);
        model.addAttribute("docente", docenteEncontrado);
        
        model.addAttribute("materias", materiaService.findAll());
        return "docente-form";
    }

    /**
     * Metodo que permite modificar un docente
     *
     * @param docenteDTO            objeto que representa un docente con los datos modificados
     * @param redirectAttributes objeto que permite enviar mensajes a la vista
     * @return la vista docentes.html
     */
    @PostMapping("modificar-docente")
    public String editarAlumno(@ModelAttribute("docente") DocenteDTO docenteDTO, RedirectAttributes redirectAttributes) {
        System.out.println(docenteDTO);
    	docenteService.edit(docenteDTO);
        redirectAttributes.addFlashAttribute("isUpdated", true);
        return "redirect:/docentes/listado";
    }

    /**
     * Metodo que permite eliminar un docente
     *
     * @param id legajo del docente a eliminar
     * @return la vista docentes.html
     */
    @GetMapping("/eliminar-docente/{id}")
    public String eliminarAlumno(@PathVariable(value = "id") Long id) {
        docenteService.deleteById(id);
        return "redirect:/docentes/listado";
    }
}
