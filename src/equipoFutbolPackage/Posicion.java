package equipoFutbolPackage;

public enum Posicion {
    PORTERO(2000, 3000),
    DEFENSA(2500, 3500),
    CENTROCAMPISTA(3500, 4000),
    DELANTERO(4000, 5000);

    private final double salarioMinimo, salarioMaximo;

    Posicion(double salarioMinimo, double salarioMaximo) {
        this.salarioMinimo = salarioMinimo;
        this.salarioMaximo = salarioMaximo;
    }

    public double getSalarioMinimo() {
        return salarioMinimo;
    }

    public double getSalarioMaximo() {
        return salarioMaximo;
    }
}
