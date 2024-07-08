package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.collections.CollectionAlumno;
import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.service.IAlumnoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoDTO alumnoDTO;

    @Autowired
    private IAlumnoService alumnoService;
    
    /**
     * Metodo que permite mostrar la pagina de alumnos
     *
     * @param model objeto que permite agregar atributos y enviarlos a la vista
     * @return la vista alumnos.html
     */
    @GetMapping("/listado")
    public String getAlumnosPage(Model model) {
        model.addAttribute("titulo", "Alumnos");
        model.addAttribute("alumnos", alumnoService.findAll());
        return "alumnos";
    }

    /**
     * Metodo que permite mostrar la pagina de nuevo alumno
     *
     * @param model objeto que permite agregar atributos y enviarlos a la vista
     * @return la vista alumno-form.html
     */
    @GetMapping("/nuevo-alumno")
    public String getNuevoAlumnoPage(Model model) {
        boolean edicion = false;
        model.addAttribute("titulo", "Nuevo Alumno");
        model.addAttribute("edicion", edicion);
        model.addAttribute("alumno", alumnoDTO);
        return "alumno-form";
    }

    /**
     * Metodo que permite guardar un nuevo alumno
     *
     * @param alumno objeto que representa un alumno
     * @return la vista alumnos.html
     */
    @PostMapping("/guardar-alumno")
    public ModelAndView guardarAlumno(@ModelAttribute("carrera") AlumnoDTO alumnoDTO) {
        ModelAndView modelView = new ModelAndView("alumnos");
        if (alumnoService.save(alumnoDTO)) {
        	modelView.addObject("alumnos", alumnoService.findAll());
            modelView.addObject("titulo", "Alumnos");
            modelView.addObject("isAdded", true);
        }
        
        return modelView;
    }

    /**
     * Metodo que permite mostrar la pagina editar un alumno
     *
     * @param model objeto que permite agregar atributos y enviarlos a la vista
     * @param dni   atributo que representa el dni del alumno
     * @return la vista alumno-form.html
     */
    @GetMapping("/editar-alumno/{dni}")
    public String getEditarAlumnoPage(Model model, @PathVariable(value = "dni") String dni) {
        boolean edicion = true;
        AlumnoDTO alumnoEncontrado = new AlumnoDTO();
        alumnoEncontrado = alumnoService.findById(dni);
        model.addAttribute("titulo", "Alumnos");
        model.addAttribute("edicion", edicion);
        model.addAttribute("alumno", alumnoEncontrado);
        System.out.println(alumnoEncontrado);
        return "alumno-form";
    }

    /**
     * Metodo que permite modificar un alumno
     *
     * @param alumno             objeto que representa un alumno
     * @param redirectAttributes objeto que permite enviar mensajes a la vista
     * @return la vista alumnos.html
     */
    @PostMapping("modificar-alumno")
    public String editarAlumno(@ModelAttribute("carrera") AlumnoDTO alumnoDTO, RedirectAttributes redirectAttributes) {
        alumnoService.edit(alumnoDTO);
        redirectAttributes.addFlashAttribute("isUpdated", true);
        return "redirect:/alumnos/listado";
    }

    /**
     * Metodo que permite eliminar un alumno
     *
     * @param dni atributo que representa el dni del alumno
     * @return la vista alumnos.html
     */
    @GetMapping("/eliminar-alumno/{dni}")
    public String eliminarAlumno(@PathVariable(value = "dni") String dni) {
        alumnoService.deleteById(dni);
        return "redirect:/alumnos/listado";
    }
}
