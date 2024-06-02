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

    public Materia(String nombre, String codigo, String curso, Byte cantidadHoras, String modalidad,
                   Docente docente, Carrera carrera) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.curso = curso;
        this.cantidadHoras = cantidadHoras;
        this.modalidad = modalidad;
        this.docente = docente;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Byte getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(Byte cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", curso='" + curso + '\'' +
                ", cantidadHoras=" + cantidadHoras +
                ", modalidad='" + modalidad + '\'' +
                ", docente=" + docente +
                ", carrera=" + carrera +
                '}';
    }
}
