package ar.edu.unju.fi.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idAlumno;

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

    @Column(name = "alu_edad")
    private String domicilio;

    @Column(name = "alu_lu")
    private String lu;

    @Column(name = "alu_estado")
    private boolean estado;

    @ManyToMany
    @JoinTable(
            name = "alumnos_materias",
            joinColumns = @JoinColumn(name = "alu_lu"),
            inverseJoinColumns = @JoinColumn(name = "mat_codigo")
    )
    List<Materia> materias = new ArrayList<Materia>();

    @ManyToOne
    @JoinColumn(name = "car_uuid")
    private Carrera carrera;
}
