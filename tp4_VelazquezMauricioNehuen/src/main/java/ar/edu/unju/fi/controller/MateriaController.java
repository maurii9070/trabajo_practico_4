package ar.edu.unju.fi.controller;

import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.collections.CollectionMateria;
import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.service.ICarreraService;
import ar.edu.unju.fi.service.IDocenteService;
import ar.edu.unju.fi.service.IMateriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/materias")
public class MateriaController {
    @Autowired
    private MateriaDTO materiaDTO;

    @Autowired
    private DocenteDTO docenteDTO;

    @Autowired
    private CarreraDTO carreraDTO;
    
    @Autowired
    private MateriaMapper materiaMapper;
    
    @Qualifier("materiaServiceCollection")
    @Autowired
    private IMateriaService materiaService;

    @Autowired
    private IDocenteService docenteService;
    
    @Autowired
    private ICarreraService carreraService;
    
    
    /**
     * Metodo que permite mostrar la pagina de materias
     *
     * @param model objeto que permite agregar atributos y enviarlos a la vista
     * @return la vista materias.html
     */
    @GetMapping("/listado")
    public String getMateriasPage(Model model) {
        model.addAttribute("titulo", "Materias");
        model.addAttribute("materias", materiaService.findAll());
        return "materias";
    }

    /**
     * Metodo que permite mostrar la pagina de nueva materia
     *
     * @param model objeto que permite agregar atributos y enviarlos a la vista
     * @return la vista materia-form.html
     */
    @GetMapping("/nueva-materia")
    public String getNuevaMateriaPage(Model model) {
        boolean edicion = false;
        model.addAttribute("titulo", "Nueva Materia");
        model.addAttribute("edicion", edicion);
        model.addAttribute("materia", materiaDTO);
        model.addAttribute("carreras", carreraService.findAll());
        model.addAttribute("docentes", docenteService.findAll());
        return "materia-form";
    }

    /**
     * Metodo que permite guardar una nueva materia
     *
     * @param materia objeto que representa una materia
     * @return la vista materias.html
     */
    @PostMapping("/guardar-materia")
    public ModelAndView guardarMateria(@ModelAttribute("carrera") Materia materia) {
        ModelAndView modelView = new ModelAndView("materias");
        docenteDTO = null;
        carreraDTO = null;
        //MODIFICAR DOCENTE Y CARRERA
//        materia.setDocente(docenteDTO);  
//        materia.setCarrera(carreraDTO);
        if (CollectionMateria.agregarMateria(materia)) {
            modelView.addObject("materias", CollectionMateria.getMaterias());
            modelView.addObject("titulo", "Materias");
            modelView.addObject("isAdded", true);
        }
        return modelView;
    }

    /**
     * Metodo que permite mostrar la pagina de editar materia
     *
     * @param model  objeto que permite agregar atributos y enviarlos a la vista
     * @param codigo codigo de la materia a editar
     * @return la vista materia-form.html
     */
    @GetMapping("/editar-materia/{codigo}")
    public String getEditarMateriaPage(Model model, @PathVariable(value = "codigo") String codigo) {
        boolean edicion = true;
        Materia materiaEncontrada = new Materia();
        materiaEncontrada = CollectionMateria.buscarMateria(codigo);
        model.addAttribute("titulo", "Materias");
        model.addAttribute("edicion", edicion);
        model.addAttribute("materia", materiaEncontrada);
        model.addAttribute("carreras", CollectionCarrera.getCarreras());
        model.addAttribute("docentes", CollectionDocente.getDocentes());
        return "materia-form";
    }

    /**
     * Metodo que permite modificar una materia
     *
     * @param materia objeto que representa una materia a modificar con sus nuevos datos
     * @return la vista materias.html
     */
    @PostMapping("modificar-materia")
    public String modificarMateria(@ModelAttribute("materia") Materia materia, RedirectAttributes redirectAttributes) {
        docenteDTO = null;
        carreraDTO = null;
        //MODIFICAR DOCENTE Y CARRERA
//        materia.setDocente(docente);
//        materia.setCarrera(carrera);
        CollectionMateria.modificarMateria(materia);
        redirectAttributes.addFlashAttribute("isUpdated", true);
        System.out.println(materia);
        return "redirect:/materias/listado";
    }

    /**
     * Metodo que permite eliminar una materia
     *
     * @param codigo codigo de la materia a eliminar
     * @return la vista materias.html
     */
    @GetMapping("/eliminar-materia/{codigo}")
    public String eliminarMateria(@PathVariable(value = "codigo") String codigo) {
        CollectionMateria.eliminarMateria(codigo);
        return "redirect:/materias/listado";
    }

}
