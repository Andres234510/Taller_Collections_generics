import java.util.Stack;

/**
 * Punto 8: splitStack.
 * Divide la pila s en dos subpilas:
 *   - primera: desde el fondo hasta la posición i (sin incluir i)
 *   - segunda: desde la posición i hasta el tope
 * Se mantiene el orden de los elementos en ambas. La pila original queda vacía,
 * porque sus elementos pasan a las dos subpilas.
 */
public class Punto8 {

    // ---------- Clase Pair para devolver las dos pilas ----------
    static class Pair<A, B> {
        private final A primero;
        private final B segundo;

        public Pair(A primero, B segundo) {
            this.primero = primero;
            this.segundo = segundo;
        }

        public A getPrimero() { return primero; }
        public B getSegundo() { return segundo; }
    }

    public static Pair<Stack<Integer>, Stack<Integer>> splitStack(Stack<Integer> s, int i) {
        int n = s.size();
        if (i < 0 || i > n) {
            throw new IllegalArgumentException("Posición inválida: i=" + i + ", tamaño=" + n);
        }

        Stack<Integer> auxiliar = new Stack<>();
        for (int k = n - 1; k >= i; k--) {
            auxiliar.push(s.pop());
        }
        Stack<Integer> segunda = new Stack<>();
        while (!auxiliar.isEmpty()) {
            segunda.push(auxiliar.pop());
        }

        Stack<Integer> primera = new Stack<>();
        while (!s.isEmpty()) {
            auxiliar.push(s.pop());
        }
        while (!auxiliar.isEmpty()) {
            primera.push(auxiliar.pop());
        }

        return new Pair<>(primera, segunda);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for (int x : new int[]{1, 2, 3, 4, 5, 6}) {
            s.push(x);
        }
        System.out.println("Pila original (fondo -> tope): " + s);

        Pair<Stack<Integer>, Stack<Integer>> resultado = splitStack(s, 3);

        System.out.println("Primera subpila:  " + resultado.getPrimero());
        System.out.println("Segunda subpila:  " + resultado.getSegundo());
    }
}