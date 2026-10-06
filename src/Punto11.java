import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Punto 11: mergeQueues - intercala los elementos de dos colas.
 * Ejemplo: [1,3,5] y [2,4,6] -> [1,2,3,4,5,6]
 * Si una cola es más larga, sus elementos sobrantes se agregan al final.
 * Las colas originales no se modifican.
 */
public class Punto11 {

    public static <T> Queue<T> mergeQueues(Queue<T> cola1, Queue<T> cola2) {
        Queue<T> resultado = new LinkedList<>();
        Iterator<T> it1 = cola1.iterator();
        Iterator<T> it2 = cola2.iterator();

        while (it1.hasNext() || it2.hasNext()) {
            if (it1.hasNext()) {
                resultado.add(it1.next());
            }
            if (it2.hasNext()) {
                resultado.add(it2.next());
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        Queue<Integer> cola1 = new LinkedList<>(java.util.List.of(1, 3, 5));
        Queue<Integer> cola2 = new LinkedList<>(java.util.List.of(2, 4, 6));
        System.out.println("cola1 = " + cola1);
        System.out.println("cola2 = " + cola2);
        System.out.println("Resultado: " + mergeQueues(cola1, cola2));

        Queue<String> a = new LinkedList<>(java.util.List.of("A", "B", "C", "D", "E"));
        Queue<String> b = new LinkedList<>(java.util.List.of("x", "y"));
        System.out.println("\nColas de distinto tamaño: " + mergeQueues(a, b));
    }
}