package ar.edu.unju.fi.model;

public class Docente {
    private String legajo;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public Docente() {
    }

    public Docente(String legajo, String nombre, String apellido, String email, String telefono) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }
}
