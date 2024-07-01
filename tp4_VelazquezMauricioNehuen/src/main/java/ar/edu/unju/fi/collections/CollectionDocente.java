package ar.edu.unju.fi.collections;

import ar.edu.unju.fi.model.Docente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public class CollectionDocente {
    public static List<Docente> docentes = new ArrayList<>();

    /**
     * Devuelve un arrayList de objetos de la clase Docente
     * @return Objeto docente
     */
    public static List<Docente> getDocentes() {
        if (docentes.isEmpty()) {
            docentes.add(new Docente(UUID.randomUUID(), "D001", "Marcelo", "Ibarra", "ibarra@correo.com", "3884789456", true, null));
            docentes.add(new Docente(UUID.randomUUID(),"D002", "Maria", "Gomez", "maria@correo.com", "3886530123",true,null));
            docentes.add(new Docente(UUID.randomUUID(),"D003", "Pedro", "Lopez", "pedro@correo.com", "388365401745",true,null));
            docentes.add(new Docente(UUID.randomUUID(),"D004", "Ana", "Martinez", "ana@correo.com", "3884569870",true,null));
            docentes.add(new Docente(UUID.randomUUID(),"D005", "Carlos", "Garcia", "carlos@correo.com", "3885620472",true,null));
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
    public static void eliminarDocente(String id) {
        docentes.removeIf(docente -> docente.getIdDocente().toString().equals(id));
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
    public static Docente buscarDocente(String id) {
        Predicate<Docente> filterCodigo = docente -> docente.getIdDocente().toString().equals(id);
        Optional<Docente> docente = docentes.stream().filter(filterCodigo).findFirst();
        return docente.orElse(null);
    }
}
