package ar.edu.unju.fi.controller;


import ar.edu.unju.fi.dto.CarreraDTO;

import ar.edu.unju.fi.service.ICarreraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/carreras")
public class CarreraController {
    @Autowired
    private CarreraDTO carreraDTO;
    
    @Autowired
    private ICarreraService carreraService;

    /**
     * Metodo que permite mostrar la pagina de carreras
     *
     * @param model modelo que se le pasa a la vista
     * @return retorna la vista carreras
     */
    @GetMapping("/listado")
    public String getCarrerasPage(Model model) {
        model.addAttribute("titulo", "Carreras");
        model.addAttribute("carreras", carreraService.findAll());
        return "carreras";
    }

    /**
     * Metodo que permite mostrar la pagina de nueva carrera
     *
     * @param model modelo que se le pasa a la vista
     * @return retorna la vista carrera-form
     */
    @GetMapping("/nueva-carrera")
    public String getNuevaCarreraPage(Model model) {
        boolean edicion = false;
        model.addAttribute("titulo", "Carreras");
        model.addAttribute("edicion", edicion);
        model.addAttribute("carrera", carreraDTO);
        return "carrera-form";
    }

    /**
     * Metodo que permite guardar una nueva carrera
     *
     * @param carrera objeto carrera que se va a guardar
     * @return retorna la vista carreras
     */
    @PostMapping("/guardar-carrera")
    public ModelAndView guardarCarrera(@ModelAttribute("carrera") CarreraDTO carreraDTO) {
        ModelAndView modelView = new ModelAndView("carreras");
        carreraDTO.setEstado(true);
        carreraService.save(carreraDTO);
        modelView.addObject("carreras", carreraService.findAll());
        modelView.addObject("isAdded", true);
        return modelView;
    }

    /**
     * Metodo que permite mostrar la pagina de editar carrera
     *
     * @param model  modelo que se le pasa a la vista
     * @param codigo codigo de la carrera que se va a editar
     * @return retorna la vista carrera-form
     */
    @GetMapping("/editar-carrera/{codigo}")
    public String getEditarCarreraPage(Model model, @PathVariable(value = "codigo") String codigo) {
        boolean edicion = true;
        CarreraDTO carreraEncontrada = new CarreraDTO() ;
        carreraEncontrada = carreraService.findById(codigo);
        model.addAttribute("titulo", "Carreras");
        model.addAttribute("edicion", edicion);
        model.addAttribute("carrera", carreraEncontrada);
        return "carrera-form";
    }

    /**
     * Metodo que permite editar una carrera
     *
     * @param carrera objeto carrera que se va a editar
     * @return retorna la vista carreras
     */
    @PostMapping("/modificar-carrera")
    public String editarCarrera(@ModelAttribute("carrera") CarreraDTO carreraDTO, RedirectAttributes redirectAttributes) {
        carreraService.edit(carreraDTO);
        redirectAttributes.addFlashAttribute("isUpdated", true);
        return "redirect:/carreras/listado";
    }

    /**
     * Metodo que permite eliminar una carrera
     *
     * @param codigo codigo de la carrera que se va a eliminar
     * @return retorna la vista carreras
     */
    @GetMapping("/eliminar-carrera/{codigo}")
    public String eliminarCarrera(@PathVariable(value = "codigo") String codigo) {
        carreraService.deleteById(codigo);
        return "redirect:/carreras/listado";
    }

}
