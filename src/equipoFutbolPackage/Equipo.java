package equipoFutbolPackage;

import java.util.*;
import java.util.stream.Collectors;

public class Equipo {
    private String nombre;
    private Set<Futbolista> futbolistas;
    private static final Map<Posicion, Integer> MAX_FUTBOLISTAS_POSICION = Map.of(
            Posicion.PORTERO, 2,
            Posicion.DEFENSA, 5,
            Posicion.CENTROCAMPISTA, 5,
            Posicion.DELANTERO, 4
    );
    
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.futbolistas = new HashSet<>();
    }

    public void agregarFutbolista(Futbolista futbolista) throws Exception {
        // Verificar si el futbolista ya existe
        if (futbolistas.contains(futbolista)) {
            throw new FutbolistaYaExisteException(
                    "El futbolista con número " + futbolista.getNumero() + " ya existe en el equipo"
            );
        }

        // Verificar si la posición está completa
        if (!puedeAgregar(futbolista.getPosicion())) {
            throw new PosicionCompletaException(
                    "La posición " + futbolista.getPosicion() + " está completa"
            );
        }

        futbolistas.add(futbolista);
    }

    public boolean puedeAgregar(Posicion pos) {
        // Cuenta cuántos futbolistas hay actualmente en la posición especificada
        long cantidad = futbolistas.stream()
                .filter(f -> f.getPosicion() == pos)
                .count();
        // Compara si la cantidad actual es menor que el máximo permitido para esa posición
        return cantidad < MAX_FUTBOLISTAS_POSICION.get(pos);
    }

    public void listarFormacionDelEquipo() {
        Map<Posicion, List<Futbolista>> porPosicion = futbolistas.stream()
                .collect(Collectors.groupingBy(Futbolista::getPosicion));

        // Orden específico: Portero, Defensa, Centrocampista, Delantero
        List<Posicion> ordenPosiciones = Arrays.asList(
                Posicion.PORTERO,
                Posicion.DEFENSA,
                Posicion.CENTROCAMPISTA,
                Posicion.DELANTERO
        );

        System.out.println("\n=== FORMACIÓN DEL EQUIPO: " + nombre + " ===");
        for (Posicion pos : ordenPosiciones) {
            System.out.println("\n" + pos + ":");
            if (porPosicion.containsKey(pos)) {
                porPosicion.get(pos).forEach(System.out::println);
            }
        }
    }

    public double calcularMediaMasaSalarial() {
        return futbolistas.stream()
                .mapToDouble(Futbolista::getSalario)  // Extrae el salario de cada futbolista
                .average()
                .orElse(0.0);  // Si no hay futbolistas, devuelve 0.0 en lugar de Optional vacío
    }

    public double calcularMediaSalarialMinima() {
        return futbolistas.stream()
                .mapToDouble(f -> f.getPosicion().getSalarioMinimo())
                .average()
                .orElse(0.0);
    }

    public List<Futbolista> obtenerVeteranos(int anyosMinimos) {
        return futbolistas.stream()
                .filter(f -> f.getEdad() >= anyosMinimos)
                .collect(Collectors.toList());
    }

    public void cuantosPorPosicion() {
        // Agrupa los futbolistas por posición y cuenta cuántos hay en cada grupo
        Map<Posicion, Long> conteo = futbolistas.stream()
                .collect(Collectors.groupingBy(Futbolista::getPosicion, Collectors.counting()));

        System.out.println("\n=== FUTBOLISTAS POR POSICIÓN ===");
        // Recorre el mapa e imprime cada posición con su cantidad de futbolistas
        conteo.forEach((pos, count) ->
                System.out.println(pos + ": " + count + " futbolistas")
        );
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Futbolista> getFutbolistas() {
        return futbolistas;
    }
}
