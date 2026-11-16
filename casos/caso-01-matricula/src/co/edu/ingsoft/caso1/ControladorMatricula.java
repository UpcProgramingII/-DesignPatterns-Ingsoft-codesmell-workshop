package co.edu.ingsoft.caso1;

import java.util.Map;

public class ControladorMatricula {

    private final ServicioMatricula servicio = new ServicioMatricula();

    // Recibe los datos del formulario web y los envía al servicio
    public String matricular(Map<String, String> form) {
        double valor = servicio.procesarMatricula(
                form.get("documento"),
                form.get("nombre"),
                form.get("email"),
                form.get("tipo"),
                Integer.parseInt(form.get("estrato")),
                Integer.parseInt(form.get("creditos")),
                form.get("fechaPago"),
                Boolean.parseBoolean(form.get("hijoEgresado")));
        return "Matrícula registrada por $" + valor;
    }

    // Reporte para tesorería: total recaudado por pregrado
    public double totalPregrado() {
        double total = 0;
        for (String r : servicio.getRegistros()) {
            String[] partes = r.split(";");
            if (partes[3].equals("PRE")) {
                total += Double.parseDouble(partes[5]);
            }
        }
        return total;
    }
}
