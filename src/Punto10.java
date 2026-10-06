import java.util.ArrayList;
import java.util.List;

/**
 * Punto 10: Sistema de alquiler de vehículos con comodines.
 */
public class Punto10 {

    // ---------- Clase base ----------
    static class Vehiculo {
        public void alquilar() {
            System.out.println("Alquilando un vehículo genérico");
        }
    }

    // ---------- Subclases ----------
    static class Auto extends Vehiculo {
        @Override
        public void alquilar() {
            System.out.println("Alquilando un auto");
        }
    }

    static class Moto extends Vehiculo {
        @Override
        public void alquilar() {
            System.out.println("Alquilando una moto");
        }

        public void conducir() {
            System.out.println("  Conduciendo la moto");
        }
    }

    static class Camion extends Vehiculo {
        @Override
        public void alquilar() {
            System.out.println("Alquilando un camión");
        }

        public void cargar() {
            System.out.println("  Cargando el camión");
        }
    }

    // ---------- Método con comodín: acepta List<Auto>, List<Moto>, List<Camion>, List<Vehiculo>... ----------
    public static void alquilarVehiculos(List<? extends Vehiculo> vehiculos) {
        for (Vehiculo v : vehiculos) {
            v.alquilar();
        }
    }

    public static void main(String[] args) {
        List<Auto> autos = new ArrayList<>();
        autos.add(new Auto());
        autos.add(new Auto());

        List<Moto> motos = new ArrayList<>();
        motos.add(new Moto());

        List<Camion> camiones = new ArrayList<>();
        camiones.add(new Camion());

        List<Vehiculo> mezcla = new ArrayList<>();
        mezcla.add(new Auto());
        mezcla.add(new Moto());
        mezcla.add(new Camion());

        System.out.println("--- Autos ---");
        alquilarVehiculos(autos);

        System.out.println("--- Motos ---");
        alquilarVehiculos(motos);
        motos.get(0).conducir();

        System.out.println("--- Camiones ---");
        alquilarVehiculos(camiones);
        camiones.get(0).cargar();

        System.out.println("--- Mezcla de vehículos ---");
        alquilarVehiculos(mezcla);
    }
}