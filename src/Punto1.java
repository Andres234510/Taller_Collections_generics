import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Punto 1: Sistema de gestión de tareas con clases y métodos genéricos.
 */
public class Punto1 {

    // ---------- Tarea ----------
    static class Tarea {
        private final String descripcion;
        private final int prioridad;
        private final Date fechaVencimiento;

        public Tarea(String descripcion, int prioridad, Date fechaVencimiento) {
            this.descripcion = descripcion;
            this.prioridad = prioridad;
            this.fechaVencimiento = fechaVencimiento;
        }

        public String getDescripcion() { return descripcion; }
        public int getPrioridad() { return prioridad; }
        public Date getFechaVencimiento() { return fechaVencimiento; }

        @Override
        public String toString() {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return "[Prioridad " + prioridad + "] " + descripcion
                    + " (vence: " + sdf.format(fechaVencimiento) + ")";
        }
    }

    // ---------- ListaDeTareas  ----------
    static class ListaDeTareas<T extends Tarea> {
        private final List<T> tareas = new ArrayList<>();

        public void agregar(T tarea) {
            if (tarea == null) throw new IllegalArgumentException("La tarea no puede ser nula");
            tareas.add(tarea);
        }

        public List<T> obtenerPorPrioridad(int prioridad) {
            List<T> resultado = new ArrayList<>();
            for (T t : tareas) {
                if (t.getPrioridad() == prioridad) {
                    resultado.add(t);
                }
            }
            return resultado;
        }

        public void mostrarOrdenadasPorFecha() {
            List<T> ordenadas = new ArrayList<>(tareas);
            ordenadas.sort(Comparator.comparing(Tarea::getFechaVencimiento));
            for (T t : ordenadas) {
                System.out.println(" - " + t);
            }
        }
    }

    // ---------- Prueba ----------
    public static void main(String[] args) {
        ListaDeTareas<Tarea> lista = new ListaDeTareas<>();

        lista.agregar(new Tarea("Entregar taller de Collections", 1,
                new GregorianCalendar(2026, Calendar.OCTOBER, 20).getTime()));
        lista.agregar(new Tarea("Preparar exposición", 2,
                new GregorianCalendar(2026, Calendar.OCTOBER, 12).getTime()));
        lista.agregar(new Tarea("Estudiar para el parcial", 1,
                new GregorianCalendar(2026, Calendar.OCTOBER, 15).getTime()));
        lista.agregar(new Tarea("Revisar correos", 3,
                new GregorianCalendar(2026, Calendar.OCTOBER, 8).getTime()));

        System.out.println("Tareas de prioridad 1:");
        for (Tarea t : lista.obtenerPorPrioridad(1)) {
            System.out.println(" - " + t);
        }

        System.out.println("\nTodas las tareas ordenadas por fecha de vencimiento:");
        lista.mostrarOrdenadasPorFecha();
    }
}