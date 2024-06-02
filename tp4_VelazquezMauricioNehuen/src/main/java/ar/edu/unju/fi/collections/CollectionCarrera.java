package ar.edu.unju.fi.collections;

import ar.edu.unju.fi.model.Carrera;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CollectionCarrera {

    private static List<Carrera> carreras = new ArrayList<>();

    /**
     * Devuelve un arrayList de objetos de la clase Carrera
     * @return Objeto carrera
     */
    public static List<Carrera> getCarreras() {
        if(carreras.isEmpty()) {
            carreras.add(new Carrera("INF001", "Ingeniería en Informática", (byte) 5, true));
            carreras.add(new Carrera("IND001", "Ingeniería Industrial", (byte) 5, true));
            carreras.add(new Carrera("APU001", "A. Programador Universitario", (byte) 4, true));
            carreras.add(new Carrera("MIN001", "Ingenieria en Minas", (byte) 5, true));
            carreras.add(new Carrera("ELE001", "Ingenieria Electrica", (byte) 5, true));
            carreras.add(new Carrera("MEC001", "Ingenieria Mecanica", (byte) 5, true));
        }
        return carreras;
    }

    /**
     * Agrega un objeto de la clase Carrera al arrayList
     * @param carrera Objeto de la clase Carrera
     */
    public static void agregarCarrera(Carrera carrera) {
        carreras.add(carrera);
    }

    /**
     * Elimina un objeto de la clase Carrera en el arrayList
     * @param codigoCarrera Objeto de la clase Carrera con atributos modificados
     */
    public static void eliminarCarerra(String codigoCarrera){
        Iterator<Carrera> iterator = carreras.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getCodigo().equals(codigoCarrera)){
                iterator.remove();
            }
        }
    }

    /**
     * Modifica un objeto de la clase Carrera en el arrayList
     * @param carrera Objeto de la clase Carrera
     */
    public static void modificarCarrera(Carrera carrera) {
        for (Carrera c : carreras) {
            if (c.getCodigo().equals(carrera.getCodigo())) {
                c.setNombre(carrera.getNombre());
                c.setCantidadAnios(carrera.getCantidadAnios());
                c.setEstado(carrera.getEstado());
            } else {
                System.out.println("No se encontro la carrera");
            }
        }
    }

    /**
     * Busca un objeto de la clase Carrera en el arrayList
     * @param codigoCarrera Objeto de la clase Carrera con atributos modificados
     * @return Objeto de la clase Carrera
     */
    public static Carrera buscarCarrera(String codigoCarrera) {
        Predicate<Carrera> filterCodigo = c -> c.getCodigo().equals(codigoCarrera);
        Optional<Carrera> carrera = carreras.stream().filter(filterCodigo).findFirst();
        if(carrera.isPresent()){
            return  carrera.get();
        } else {
            return null;
        }
    }
}
