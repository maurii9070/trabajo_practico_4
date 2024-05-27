package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class Alumno {
    private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String domicilio;
    private String lu;

    public Alumno() {
    }

    public Alumno(String dni, String nombre, String apellido, String email, String telefono, LocalDate fechaNacimiento, String domicilio, String lu) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.lu = lu;
    }
}
