import java.util.LinkedHashSet;
import java.util.Set;
import java.util.*;

/**
 * Punto 3: ¿Qué imprime la ejecución del programa?
 *
 * RESPUESTA:  [Chicago, Boston, Alabama]
 *
 * EXPLICACIÓN:
 *  - LinkedHashSet es un Set (no permite elementos repetidos) que además
 *    conserva el orden de inserción.
 *  - Se agregan "Chicago", "Boston", "Alabama" y de nuevo "Chicago".
 *  - Aunque cada "Chicago" es un objeto String distinto (new String), el Set
 *    compara con equals()/hashCode(), y ambos son iguales, por lo que el
 *    segundo "Chicago" se ignora (add devuelve false).
 *  - Al imprimir, se respeta el orden en que se insertaron los elementos
 *    únicos: Chicago, Boston, Alabama.
 */
public class Punto3 {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();
        set.add(new String("Chicago"));
        set.add(new String("Boston"));
        set.add(new String("Alabama"));
        set.add(new String("Chicago"));
        System.out.println(set);
    }
}