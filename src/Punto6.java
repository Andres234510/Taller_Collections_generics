import java.util.List;

/**
 * Punto 6: Método genérico maximo para una lista de objetos Comparable.
 */
public class Punto6 {

    public static <T extends Comparable<? super T>> T maximo(List<T> lista) {
        if (lista == null || lista.isEmpty()) {
            throw new IllegalArgumentException("La lista no puede estar vacía");
        }
        T max = lista.get(0);
        for (T elemento : lista) {
            if (elemento.compareTo(max) > 0) {
                max = elemento;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> numeros = List.of(4, 17, 9, 2, 15);
        List<String> palabras = List.of("manzana", "pera", "uva", "naranja");
        List<Double> decimales = List.of(3.5, 1.2, 9.8, 7.1);

        System.out.println("Máximo de enteros:   " + maximo(numeros));
        System.out.println("Máximo de cadenas:   " + maximo(palabras));
        System.out.println("Máximo de decimales: " + maximo(decimales));
    }
}