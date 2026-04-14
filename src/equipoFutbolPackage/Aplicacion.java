package equipoFutbolPackage;

public class Aplicacion {
    private static Equipo equipo;

    public static void main(String[] args) {
        equipo = new Equipo("Ganadores");
        cargaInicial();

        // Mostrar formación del equipo
        equipo.listarFormacionDelEquipo();

        // Calcular y mostrar media salarial
        System.out.println("\n=== ESTADÍSTICAS SALARIALES ===");
        System.out.println("Media masa salarial: " + equipo.calcularMediaMasaSalarial());
        System.out.println("Media salarial mínima: " + equipo.calcularMediaSalarialMinima());

        // Obtener veteranos
        System.out.println("\n=== VETERANOS (30+ años) ===");
        equipo.obtenerVeteranos(30).forEach(System.out::println);

        // Mostrar cantidad por posición
        equipo.cuantosPorPosicion();
    }

    public static void cargaInicial() {
        // Porteros (Rango 2000-3000)
        crearFutbolista(1, "Dimitrievski", Posicion.PORTERO, 2800, 32);
        crearFutbolista(1, "Dimitrievski2", Posicion.PORTERO, 2800, 32);
        crearFutbolista(2, "Andrés Fernández", Posicion.PORTERO, 2500, 39);
        crearFutbolista(3, "Jaume Doménech", Posicion.PORTERO, 2100, 33);

        // Defensas (Rango 2500-3500)
        crearFutbolista(4, "Cristhian Mosquera", Posicion.DEFENSA, 3100, 19);
        crearFutbolista(12, "Unai Elgezabal", Posicion.DEFENSA, 2900, 33);
        crearFutbolista(14, "José Luis Gayà", Posicion.DEFENSA, 3400, 30);
        crearFutbolista(22, "Antonio Rüdiger", Posicion.DEFENSA, 14580, 33);
        crearFutbolista(4, "Ronald Araújo", Posicion.DEFENSA, 10000, 27);
        crearFutbolista(24, "Robin Le Normand", Posicion.DEFENSA, 4000, 29);

        // Centrocampistas (Rango 3500-4000)
        crearFutbolista(22, "Dani Parejo", Posicion.CENTROCAMPISTA, 3850, 36);
        crearFutbolista(25, "Brais Méndez", Posicion.CENTROCAMPISTA, 3950, 29);
        crearFutbolista(28, "Álex Baena", Posicion.CENTROCAMPISTA, 4000, 24);
        crearFutbolista(31, "Martin Zubimendi", Posicion.CENTROCAMPISTA, 3750, 27);
        crearFutbolista(34, "Fermín López", Posicion.CENTROCAMPISTA, 3550, 22);

        // Delanteros (Rango 4000-5000)
        crearFutbolista(9, "Morales", Posicion.DELANTERO, 4200, 38);
        crearFutbolista(5, "Hugo Duro", Posicion.DELANTERO, 4900, 24);
        crearFutbolista(6, "Iván Romero", Posicion.DELANTERO, 4100, 23);
        crearFutbolista(11, "Dani Gómez", Posicion.DELANTERO, 4300, 26);
        crearFutbolista(9, "Fabrício Santos", Posicion.DELANTERO, 4500, 24);
    }

    private static void crearFutbolista(int numero, String nombre, Posicion posicion,
                                        double salario, int edad) {
        try {
            Futbolista futbolista = new Futbolista(numero, nombre, posicion, salario, edad);
            equipo.agregarFutbolista(futbolista);
            System.out.println("Añadido: " + nombre);
        } catch (SalarioInvalidoException e) {
            System.out.println("ERROR - " + nombre + ": " + e.getMessage());
        } catch (FutbolistaYaExisteException e) {
            System.out.println("ERROR - " + nombre + ": " + e.getMessage());
        } catch (PosicionCompletaException e) {
            System.out.println("ERROR - " + nombre + ": " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR - " + nombre + ": " + e.getMessage());
        }
    }
}