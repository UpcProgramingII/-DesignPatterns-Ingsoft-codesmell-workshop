package co.edu.ingsoft.caso4;

import java.util.List;

public class CentralDespacho {

    // Elige el repartidor disponible con mejor calificación que pueda cubrir la distancia
    // (las bicicletas sólo atienden pedidos de hasta 3 km)
    public Repartidor mejorRepartidor(List<Repartidor> repartidores, Pedido pedido) {
        Repartidor mejor = null;
        for (Repartidor r : repartidores) {
            if (r.disponible && r.pedidosAsignados.size() < 3
                    && (pedido.distanciaKm <= 3 || r.vehiculo.equals("MOTO"))) {
                if (mejor == null || r.calificacion > mejor.calificacion) {
                    mejor = r;
                }
            }
        }
        return mejor;
    }

    public void despachar(List<Repartidor> repartidores, Pedido pedido) {
        Repartidor r = mejorRepartidor(repartidores, pedido);
        if (r == null) {
            throw new IllegalStateException("No hay repartidores disponibles");
        }
        pedido.asignar(r);
    }

    public String resumenTurno(Repartidor r) {
        return r.nombre + " (" + r.vehiculo + "): " + r.entregasRealizadas + " entregas, calificación "
                + String.format("%.1f", r.calificacion) + ", ganancia $" + r.gananciaDelDia();
    }
}
