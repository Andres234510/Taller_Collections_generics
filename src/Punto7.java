/**
 * Punto 7: Interfaz genérica Comparador<T>.
 */
public class Punto7 {

    // ---------- Interfaz genérica ----------
    interface Comparador<T> {
        int comparar(T a, T b);
    }

    // ---------- Implementación: sirve para números, cadenas o cualquier tipo Comparable ----------
    static class ComparadorNatural<T extends Comparable<T>> implements Comparador<T> {
        @Override
        public int comparar(T a, T b) {
            return a.compareTo(b);
        }
    }

    // ---------- Un tipo propio que implementa Comparable ----------
    static class Persona implements Comparable<Persona> {
        private final String nombre;
        private final int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        @Override
        public int compareTo(Persona otra) {
            return Integer.compare(this.edad, otra.edad);
        }

        @Override
        public String toString() {
            return nombre + " (" + edad + ")";
        }
    }

    public static void main(String[] args) {
        Comparador<Integer> compNumeros = new ComparadorNatural<>();
        System.out.println("comparar(5, 9)    = " + compNumeros.comparar(5, 9));
        System.out.println("comparar(9, 5)    = " + compNumeros.comparar(9, 5));
        System.out.println("comparar(7, 7)    = " + compNumeros.comparar(7, 7));

        Comparador<String> compCadenas = new ComparadorNatural<>();
        System.out.println("comparar(\"ana\", \"luis\") = " + compCadenas.comparar("ana", "luis"));
        System.out.println("comparar(\"zeta\", \"alfa\") = " + compCadenas.comparar("zeta", "alfa"));

        Comparador<Persona> compPersonas = new ComparadorNatural<>();
        Persona p1 = new Persona("Ana", 20);
        Persona p2 = new Persona("Luis", 30);
        System.out.println("comparar(" + p1 + ", " + p2 + ") = " + compPersonas.comparar(p1, p2));
    }
}