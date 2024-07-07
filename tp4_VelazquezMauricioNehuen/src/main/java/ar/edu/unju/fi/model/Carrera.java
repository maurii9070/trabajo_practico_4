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
@Table(name = "carreras")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long idCarrera;

    @Column(name = "car_codigo")
    private String codigo;

    @Column(name = "car_nombre")
    private String nombre;

    @Column(name = "car_duracion")
    private Byte cantidadAnios;

    @Column(name = "car_estado")
    private Boolean estado;

    @OneToMany(mappedBy = "carrera")
    List<Alumno> alumnos = new ArrayList<Alumno>();

    @OneToMany(mappedBy = "carrera")
    List<Materia> materias = new ArrayList<Materia>();
    
    
    @Override
    public String toString() {
        return "Carrera{" +
               "idCarrera=" + idCarrera +
               ", codigo='" + codigo + '\'' +
               ", nombre='" + nombre + '\'' +
               ", cantidadAnios=" + cantidadAnios +
               ", estado=" + estado +
               // No incluir la relación alumnos y materias directamente en toString()
               '}';
    }

}
