package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.collections.CollectionAlumno;
import ar.edu.unju.fi.model.Alumno;
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
    private Alumno alumno;

    /**
     * Metodo que permite mostrar la pagina de alumnos
     *
     * @param model objeto que permite agregar atributos y enviarlos a la vista
     * @return la vista alumnos.html
     */
    @GetMapping("/listado")
    public String getAlumnosPage(Model model) {
        model.addAttribute("titulo", "Alumnos");
        model.addAttribute("alumnos", CollectionAlumno.getAlumnos());
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
        model.addAttribute("alumno", alumno);
        return "alumno-form";
    }

    /**
     * Metodo que permite guardar un nuevo alumno
     *
     * @param alumno objeto que representa un alumno
     * @return la vista alumnos.html
     */
    @PostMapping("/guardar-alumno")
    public ModelAndView guardarAlumno(@ModelAttribute("carrera") Alumno alumno) {
        ModelAndView modelView = new ModelAndView("alumnos");
        CollectionAlumno.agregarAlumno(alumno);
        modelView.addObject("alumnos", CollectionAlumno.getAlumnos());
        modelView.addObject("titulo", "Alumnos");
        modelView.addObject("isAdded", true);
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
        Alumno alumnoEncontrado = new Alumno();
        alumnoEncontrado = CollectionAlumno.buscarAlumno(dni);
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
    public String editarAlumno(@ModelAttribute("carrera") Alumno alumno, RedirectAttributes redirectAttributes) {
        CollectionAlumno.modificarAlumno(alumno);
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
        CollectionAlumno.eliminarAlumno(dni);
        return "redirect:/alumnos/listado";
    }
}
