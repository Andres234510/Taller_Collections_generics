import java.util.Stack;

/**
 * Punto 5: spliceStack.
 * Quita de la pila s los elementos desde la posición i hasta j (sin incluir j),
 * contando desde el fondo (posición 0 = fondo), y los devuelve en una nueva pila.
 * El orden se conserva en ambas pilas.
 */
public class Punto5 {

    public static Stack<Integer> spliceStack(Stack<Integer> s, int i, int j) {
        int n = s.size();
        if (i < 0 || j > n || i > j) {
            throw new IllegalArgumentException("Posiciones inválidas: i=" + i + ", j=" + j + ", tamaño=" + n);
        }

        // 1. Sacar los elementos de las posiciones j..n-1 (la parte de arriba) y guardarlos.
        Stack<Integer> arriba = new Stack<>();
        for (int k = n - 1; k >= j; k--) {
            arriba.push(s.pop());
        }

        // 2. Sacar los elementos de las posiciones i..j-1 (los que se quitan). Quedan invertidos.
        Stack<Integer> invertida = new Stack<>();
        for (int k = j - 1; k >= i; k--) {
            invertida.push(s.pop());
        }

        // 3. Invertir de nuevo para dejar el orden original en la pila resultado.
        Stack<Integer> resultado = new Stack<>();
        while (!invertida.isEmpty()) {
            resultado.push(invertida.pop());
        }

        // 4. Devolver a s los elementos de arriba, en su orden original.
        while (!arriba.isEmpty()) {
            s.push(arriba.pop());
        }

        return resultado;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for (int x : new int[]{10, 20, 30, 40, 50, 60}) {
            s.push(x);
        }
        System.out.println("Pila original (fondo -> tope): " + s);

        Stack<Integer> quitados = spliceStack(s, 2, 5);

        System.out.println("Pila resultado (los quitados): " + quitados);
        System.out.println("Pila original después:         " + s);
    }
}