package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.collections.CollectionAlumno;
import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.service.IAlumnoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private AlumnoMapper alumnoMapper;
    
    @Qualifier("alumnoServiceCollection")
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
     * @param alumnoDTO objeto que representa un alumno
     * @return la vista alumnos.html
     */
    @PostMapping("/guardar-alumno")
    public ModelAndView guardarAlumno(@ModelAttribute("carrera") AlumnoDTO alumnoDTO) {
        ModelAndView modelView = new ModelAndView("alumnos");
        // Set ID
        alumnoDTO.setIdAlumno((long)20);
        alumnoDTO.setEstado(true);
        Alumno alumnoResultado= alumnoService.save(alumnoDTO);
        
        modelView.addObject("alumnos", alumnoService.findAll());
        modelView.addObject("titulo", "Alumnos");
        modelView.addObject("isAdded", true);
        
        System.out.println(alumnoService.findAll());
        return modelView;
    }

    /**
     * Metodo que permite mostrar la pagina editar un alumno
     *
     * @param model objeto que permite agregar atributos y enviarlos a la vista
     * @param id   atributo que representa el dni del alumno
     * @return la vista alumno-form.html
     */
    @GetMapping("/editar-alumno/{id}")
    public String getEditarAlumnoPage(Model model, @PathVariable(value = "id") Long id) {
    	System.out.println(id);
        boolean edicion = true;
        AlumnoDTO alumnoEncontrado = new AlumnoDTO();
        alumnoEncontrado = alumnoService.findById(id);
        
        model.addAttribute("titulo", "Alumnos");
        model.addAttribute("edicion", edicion);
        model.addAttribute("alumno", alumnoMapper.toAlumno(alumnoEncontrado) );
        System.out.println(alumnoEncontrado);
        return "alumno-form";
    }

    /**
     * Metodo que permite modificar un alumno
     *
     * @param alumnoDTO             objeto que representa un alumno
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
     * @param id atributo que representa el dni del alumno
     * @return la vista alumnos.html
     */
    @GetMapping("/eliminar-alumno/{id}")
    public String eliminarAlumno(@PathVariable(value = "id") Long id) {
        alumnoService.deleteById(id);
        return "redirect:/alumnos/listado";
    }
}
