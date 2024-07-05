package ar.edu.unju.fi.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alu_id")
    private Long idAlumno;

    @Column(name = "alu_dni")
    private String dni;

    @Column(name = "alu_nombre")
    private String nombre;

    @Column(name = "alu_apellido")
    private String apellido;

    @Column(name = "alu_email")
    private String email;

    @Column(name = "alu_telefono")
    private String telefono;

    @Column(name = "alu_fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "alu_domicilio")
    private String domicilio;

    @Column(name = "alu_lu")
    private String lu;

    @Column(name = "alu_estado")
    private boolean estado;

    @ManyToMany
    @JoinTable(
            name = "alumnos_materias",
            joinColumns = @JoinColumn(name = "alu_id"),
            inverseJoinColumns = @JoinColumn(name = "mat_id")
    )
    List<Materia> materias = new ArrayList<Materia>();

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Carrera carrera;
    
    @Transient
    private Long carreraId; // Campo para almacenar el ID de la carrera seleccionada desde el formulario
    
    /*
     * esta modificacion es para evitar un error en la vista
     */
    
    @Override
    public String toString() {
        return "Alumno{" +
               "idAlumno=" + idAlumno +
               ", dni='" + dni + '\'' +
               ", nombre='" + nombre + '\'' +
               ", apellido='" + apellido + '\'' +
               ", email='" + email + '\'' +
               ", telefono='" + telefono + '\'' +
               ", fechaNacimiento=" + fechaNacimiento +
               ", domicilio='" + domicilio + '\'' +
               ", lu='" + lu + '\'' +
               ", estado=" + estado +
               // No incluir la relación carrera directamente en toString()
               '}';
    }
    
    
}
