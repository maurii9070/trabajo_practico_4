package ar.edu.unju.fi.controller;



import ar.edu.unju.fi.dto.DocenteDTO;

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.service.IDocenteService;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private IDocenteService docenteService;
    
    

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
        return "docente-form";
    }

    /**
     * Metodo que permite guardar un nuevo docente
     *
     * @param docente objeto que representa un docente
     * @return la vista docentes.html
     */
    @PostMapping("/guardar-docente")
    public ModelAndView guardarDocente(@ModelAttribute("carrera") Docente docente) {
        ModelAndView modelView = new ModelAndView("docentes");
        docenteService.save(docenteDTO);
        modelView.addObject("docentes", docenteService.findAll());
        modelView.addObject("titulo", "Alumnos");
        modelView.addObject("isAdded", true);
        return modelView;
    }

    /**
     * Metodo que permite mostrar la pagina de editar docente
     *
     * @param model  objeto que permite agregar atributos y enviarlos a la vista
     * @param legajo legajo del docente a editar
     * @return la vista docente-form.html
     */
    @GetMapping("/editar-docente/{legajo}")
    public String getEditarDocentePage(Model model, @PathVariable(value = "legajo") String legajo) {
        boolean edicion = true;
        DocenteDTO docenteEncontrado = new DocenteDTO();
        docenteEncontrado = docenteService.findById(legajo);
        model.addAttribute("titulo", "Docentes");
        model.addAttribute("edicion", edicion);
        model.addAttribute("docente", docenteEncontrado);
        return "docente-form";
    }

    /**
     * Metodo que permite modificar un docente
     *
     * @param docente            objeto que representa un docente con los datos modificados
     * @param redirectAttributes objeto que permite enviar mensajes a la vista
     * @return la vista docentes.html
     */
    @PostMapping("modificar-docente")
    public String editarAlumno(@ModelAttribute("docente") DocenteDTO docenteDTO, RedirectAttributes redirectAttributes) {
        docenteService.edit(docenteDTO);
        redirectAttributes.addFlashAttribute("isUpdated", true);
        return "redirect:/docentes/listado";
    }

    /**
     * Metodo que permite eliminar un docente
     *
     * @param legajo legajo del docente a eliminar
     * @return la vista docentes.html
     */
    @GetMapping("/eliminar-docente/{legajo}")
    public String eliminarAlumno(@PathVariable(value = "legajo") String legajo) {
        docenteService.deleteById(legajo);
        return "redirect:/docentes/listado";
    }
}
