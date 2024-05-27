package ar.edu.unju.fi.model;

public class Materia {
    private String nombre;
    private String codigo;
    private String curso;
    private Byte cantidadHoras;
    private String modalidad;
    private Docente docente;
    private Carrera carrera;

    public Materia() {
    }

    public Materia(String nombre, String codigo, String curso, Byte cantidadHoras, String modalidad, Docente docente, Carrera carrera) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.curso = curso;
        this.cantidadHoras = cantidadHoras;
        this.modalidad = modalidad;
        this.docente = docente;
        this.carrera = carrera;
    }


}
