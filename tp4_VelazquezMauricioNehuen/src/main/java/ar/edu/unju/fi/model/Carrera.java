package ar.edu.unju.fi.model;

public class Carrera {
    private String codigo;
    private String nombre;
    private Byte cantidadAnios;
    private Boolean estado;

    public Carrera() {
    }

    public Carrera(String codigo, String nombre, Byte cantidadAnios, Boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadAnios = cantidadAnios;
        this.estado = estado;
    }
}
