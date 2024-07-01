package ar.edu.unju.fi.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mat_id")
    private Long idMateria;

    @Column(name = "mat_nombre")
    private String nombre;

    @Column(name = "mat_codigo")
    private String codigo;

    @Column(name = "mat_curso")
    private String curso;

    @Column(name = "mat_horas")
    private Byte cantidadHoras;

    @Column(name = "mat_modalidad")
    private String modalidad;

    @Column(name = "mat_estado")
    private boolean estado;

    @OneToOne(mappedBy = "materia")
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Carrera carrera;

    @ManyToMany(mappedBy = "materias")
    List<Alumno> alumnos = new ArrayList<Alumno>();
}
