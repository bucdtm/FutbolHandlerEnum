package equipoFutbolPackage;

public class Futbolista {
    private String nombre;
    private int edad;
    private int numero;
    private Posicion posicion;
    private double salario;

    public Futbolista(int numero, String nombre, Posicion posicion, double salario, int edad)
            throws SalarioInvalidoException {
        if (salario < posicion.getSalarioMinimo() || salario > posicion.getSalarioMaximo()) {
            throw new SalarioInvalidoException(
                    "Salario " + salario + " fuera del rango para " + posicion +
                            " (" + posicion.getSalarioMinimo() + "-" + posicion.getSalarioMaximo() + ")"
            );
        }
        this.numero = numero;
        this.nombre = nombre;
        this.posicion = posicion;
        this.salario = salario;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Futbolista{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", posicion=" + posicion +
                ", salario=" + salario +
                ", edad=" + edad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Futbolista that = (Futbolista) o;
        return numero == that.numero;
    }

    @Override
    public int hashCode() {
        // Deteccion de duplicados
        return Integer.hashCode(numero);
    }
}