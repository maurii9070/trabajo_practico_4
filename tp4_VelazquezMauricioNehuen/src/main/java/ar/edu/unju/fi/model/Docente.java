package ar.edu.unju.fi.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "docentes")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_id")
    private Long idDocente;

    @Column(name = "doc_legajo")
    private String legajo;

    @Column(name = "doc_nombre")
    private String nombre;

    @Column(name = "doc_apellido")
    private String apellido;

    @Column(name = "doc_email")
    private String email;

    @Column(name = "doc_telefono")
    private String telefono;

    @Column(name = "doc_estado")
    private boolean estado;

    @OneToOne(mappedBy = "docente")
    private Materia materia;
    

    
}
