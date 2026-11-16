package co.edu.ingsoft.caso4;

public class Pedido {

    String codigo;
    double distanciaKm;
    double propina;
    String estado = "CREADO"; // CREADO, ASIGNADO, ENTREGADO
    Repartidor repartidor;

    public Pedido(String codigo, double distanciaKm, double propina) {
        this.codigo = codigo;
        this.distanciaKm = distanciaKm;
        this.propina = propina;
    }

    void asignar(Repartidor r) {
        if (!r.disponible || r.pedidosAsignados.size() >= 3) {
            throw new IllegalStateException("Repartidor sin capacidad");
        }
        repartidor = r;
        r.pedidosAsignados.add(this);
        if (r.pedidosAsignados.size() == 3) {
            r.disponible = false;
        }
        estado = "ASIGNADO";
    }

    void entregar(int estrellas) {
        estado = "ENTREGADO";
        repartidor.entregasRealizadas++;
        repartidor.calificacion = (repartidor.calificacion * (repartidor.entregasRealizadas - 1) + estrellas)
                / repartidor.entregasRealizadas;
        repartidor.pedidosAsignados.remove(this);
        repartidor.disponible = true;
    }
}
