package ar.edu.unju.fi.collections;

import ar.edu.unju.fi.model.Docente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CollectionDocente {
    public static List<Docente> docentes = new ArrayList<>();

    /**
     * Devuelve un arrayList de objetos de la clase Docente
     * @return Objeto docente
     */
    public static List<Docente> getDocentes() {
        if (docentes.isEmpty()) {
            docentes.add(new Docente("D001", "Juan", "Perez", "juan@correo.com", "3884552367"));
            docentes.add(new Docente("D002", "Maria", "Gomez", "maria@correo.com", "3886530123"));
            docentes.add(new Docente("D003", "Pedro", "Lopez", "pedro@correo.com", "388365401745"));
            docentes.add(new Docente("D004", "Ana", "Martinez", "ana@correo.com", "3884569870"));
            docentes.add(new Docente("D005", "Carlos", "Garcia", "carlos@correo.com", "3885620472"));
        }
        return docentes;
    }

    /**
     * Agrega un objeto de la clase Docente al arrayList
     * @param docente Objeto de la clase Docente
     * @return 
     */
    public static boolean agregarDocente(Docente docente) {
        docentes.add(docente);
        
        return true;
    }

    /**
     * Elimina un objeto de la clase Docente en el arrayList
     * @param legajo Objeto de la clase Docente con atributos modificados
     */
    public static void eliminarDocente(String legajo) {
        docentes.removeIf(docente -> docente.getLegajo().equals(legajo));
    }

    /**
     * Modifica un objeto de la clase Docente en el arrayList
     * @param docente Objeto de la clase Docente
     */
    public static void modificarDocente(Docente docente) {
        for (Docente d : docentes) {
            if (d.getLegajo().equals(docente.getLegajo())) {
                d.setNombre(docente.getNombre());
                d.setApellido(docente.getApellido());
                d.setEmail(docente.getEmail());
                d.setTelefono(docente.getTelefono());
            }
        }
    }

    /**
     * Busca un objeto de la clase Docente en el arrayList
     * @param legajo Objeto de la clase Docente
     * @return Objeto docente
     */
    public static Docente buscarDocente(String legajo) {
        Predicate<Docente> filterCodigo = docente -> docente.getLegajo().equals(legajo);
        Optional<Docente> docente = docentes.stream().filter(filterCodigo).findFirst();
        return docente.orElse(null);
    }
}
