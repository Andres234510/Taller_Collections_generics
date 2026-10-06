import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Punto 4: Repositorio<T> recorrible con for-each, más un recorrido personalizado
 * de atrás hacia adelante.
 */
public class Punto4 {

    static class Repositorio<T> implements Iterable<T> {
        private final List<T> elementos = new ArrayList<>();

        public void agregar(T elemento) {
            elementos.add(elemento);
        }

        public T obtener(int indice) {
            return elementos.get(indice);
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private int posicion = 0;

                @Override
                public boolean hasNext() {
                    return posicion < elementos.size();
                }

                @Override
                public T next() {
                    if (!hasNext()) throw new NoSuchElementException();
                    return elementos.get(posicion++);
                }
            };
        }

        public Iterator<T> iteratorInverso() {
            return new Iterator<T>() {
                private int posicion = elementos.size() - 1;

                @Override
                public boolean hasNext() {
                    return posicion >= 0;
                }

                @Override
                public T next() {
                    if (!hasNext()) throw new NoSuchElementException();
                    return elementos.get(posicion--);
                }
            };
        }

        public Iterable<T> enReversa() {
            return this::iteratorInverso;
        }
    }

    public static void main(String[] args) {
        Repositorio<String> repo = new Repositorio<>();
        repo.agregar("A");
        repo.agregar("B");
        repo.agregar("C");
        repo.agregar("D");

        System.out.println("obtener(2) = " + repo.obtener(2));

        System.out.print("Recorrido normal (for-each): ");
        for (String s : repo) {
            System.out.print(s + " ");
        }

        System.out.print("\nRecorrido inverso (for-each con enReversa()): ");
        for (String s : repo.enReversa()) {
            System.out.print(s + " ");
        }

        System.out.print("\nRecorrido inverso (iterador explícito): ");
        Iterator<String> it = repo.iteratorInverso();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}