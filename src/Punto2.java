import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Punto 2: Clase PairList genérica que almacena pares (clave, valor).
 */
public class Punto2 {

    // ---------- Par (clave, valor) ----------
    static class Par<K, V> {
        private final K clave;
        private final V valor;

        public Par(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }

        public K getClave() { return clave; }
        public V getValor() { return valor; }

        @Override
        public String toString() {
            return "(" + clave + ", " + valor + ")";
        }
    }

    // ---------- PairList ----------
    static class PairList<K, V> {
        private final List<Par<K, V>> pares = new ArrayList<>();

        public void agregar(K clave, V valor) {
            pares.add(new Par<>(clave, valor));
        }

        public boolean eliminar(K clave) {
            for (int i = 0; i < pares.size(); i++) {
                if (pares.get(i).getClave().equals(clave)) {
                    pares.remove(i);
                    return true;
                }
            }
            return false;
        }

        public Optional<V> obtener(K clave) {
            for (Par<K, V> p : pares) {
                if (p.getClave().equals(clave)) {
                    return Optional.of(p.getValor());
                }
            }
            return Optional.empty();
        }

        public Par<K, V> obtenerPar(int indice) {
            return pares.get(indice);
        }

        public int tamanio() {
            return pares.size();
        }

        @Override
        public String toString() {
            return pares.toString();
        }
    }

    // ---------- Prueba ----------
    public static void main(String[] args) {
        PairList<String, Integer> edades = new PairList<>();
        edades.agregar("Ana", 20);
        edades.agregar("Luis", 25);
        edades.agregar("Marta", 30);

        System.out.println("Lista: " + edades);
        System.out.println("Valor de Luis: " + edades.obtener("Luis").orElse(null));
        System.out.println("Par en la posición 2: " + edades.obtenerPar(2));

        System.out.println("¿Se eliminó Ana? " + edades.eliminar("Ana"));
        System.out.println("¿Se eliminó Pedro? " + edades.eliminar("Pedro"));
        System.out.println("Lista final: " + edades + " (tamaño " + edades.tamanio() + ")");
    }
}