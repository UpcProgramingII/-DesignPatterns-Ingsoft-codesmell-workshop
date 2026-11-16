package co.edu.ingsoft.caso4;

import java.util.ArrayList;
import java.util.List;

public class Repartidor {

    String nombre;
    String vehiculo; // "MOTO" o "BICICLETA"
    List<Pedido> pedidosAsignados = new ArrayList<>();
    double calificacion = 5.0;
    int entregasRealizadas;
    boolean disponible = true;

    public Repartidor(String nombre, String vehiculo) {
        this.nombre = nombre;
        this.vehiculo = vehiculo;
    }

    // Ganancia del día: tarifa por km de cada pedido entregado + propina
    double gananciaDelDia() {
        double total = 0;
        for (Pedido p : pedidosAsignados) {
            if (p.estado.equals("ENTREGADO")) {
                total += p.distanciaKm * 1200 + p.propina;
            }
        }
        return total;
    }
}
