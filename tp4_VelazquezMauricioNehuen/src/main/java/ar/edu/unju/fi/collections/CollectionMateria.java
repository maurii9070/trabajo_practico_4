package ar.edu.unju.fi.collections;

import ar.edu.unju.fi.model.Materia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CollectionMateria {

    private static List<Materia> materias = new ArrayList<>();

    /**
     * Devuelve un arrayList de objetos de la clase Materia
     * @return Objeto materia
     */
    public static List<Materia> getMaterias() {
        if(materias.isEmpty()) {
            materias.add(new Materia("Programación I", "PRO001", "1er Año", (byte) 4,
                    "Presencial", null, null));
            materias.add(new Materia("Fisica 1", "FIS001", "1do Año", (byte) 6,
                    "Presencial", null, null));
            materias.add(new Materia("Algebra 1", "ALG001", "1er Año", (byte) 4,
                    "Presencial", null, null));
            materias.add(new Materia("Ingles V", "ING001", "3er Año", (byte) 4,
                    "Presencial", null, null));
            materias.add(new Materia("POO", "POO005", "2do Año", (byte) 4,
                    "Presencial", null, null));
        }
        return materias;
    }

    /**
     * Agrega un objeto de la clase Materia al arrayList
     * @param materia Objeto de la clase Materia
     */
    public static void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    /**
     * Elimina un objeto de la clase Materia en el arrayList
     * @param codigoMateria Objeto de la clase Materia con atributos modificados
     */
    public static void eliminarMateria(String codigoMateria) {
        Iterator<Materia> iterator = materias.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().getCodigo().equals(codigoMateria)) {
                iterator.remove();
            }
        }
    }

    /**
     * Modifica un objeto de la clase Materia en el arrayList
     * @param materia Objeto de la clase Materia
     */
    public static void modificarMateria(Materia materia) {
        for (Materia m : materias) {
            if (m.getCodigo().equals(materia.getCodigo())) {
                m.setNombre(materia.getNombre());
                m.setCurso(materia.getCurso());
                m.setCantidadHoras(materia.getCantidadHoras());
                m.setModalidad(materia.getModalidad());
                m.setDocente(materia.getDocente());
                m.setCarrera(materia.getCarrera());
            }
        }
    }

    /**
     * Busca un objeto de la clase Materia en el arrayList
     * @param codigoMateria Objeto de la clase Materia con atributos modificados
     * @return Objeto de la clase Materia
     */
    public static Materia buscarMateria(String codigoMateria) {
        Predicate<Materia> filterCodigo = m -> m.getCodigo().equals(codigoMateria);
        Optional<Materia> materia = materias.stream().filter(filterCodigo).findFirst();
        return materia.orElse(null);
    }



}
