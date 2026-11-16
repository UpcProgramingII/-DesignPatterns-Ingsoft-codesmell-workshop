package co.edu.ingsoft.caso1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicioMatricula {

    private final List<String> registros = new ArrayList<>();

    // Procesa la matrícula: valida, calcula valor, aplica descuentos y recargos,
    // registra y notifica. tipo: "PRE" = pregrado, "POS" = posgrado, "EC" = educación continua
    public double procesarMatricula(String documento, String nombre, String email,
                                    String tipo, int estrato, int creditos,
                                    String fechaPago, boolean esHijoDeEgresado) {
        // validar datos
        if (documento == null || documento.length() < 6) {
            throw new IllegalArgumentException("documento inválido");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("email inválido");
        }
        if (creditos < 1 || creditos > 24) {
            throw new IllegalArgumentException("créditos fuera de rango");
        }

        // calcular valor base según el tipo de programa
        double valor = 0;
        if (tipo.equals("PRE")) {
            valor = creditos * 412000;
        } else if (tipo.equals("POS")) {
            valor = creditos * 895000;
        } else if (tipo.equals("EC")) {
            valor = creditos * 230000;
        }

        // descuento por estrato (solo aplica a pregrado)
        if (tipo.equals("PRE")) {
            if (estrato == 1 || estrato == 2) {
                valor = valor - valor * 0.40;
            } else if (estrato == 3) {
                valor = valor - valor * 0.20;
            }
        }

        // descuento por ser hijo de egresado
        if (esHijoDeEgresado) {
            valor = valor - valor * 0.10;
        }

        // recargo por pago extemporáneo (después del 15 de enero o del 15 de julio)
        LocalDate fecha = LocalDate.parse(fechaPago);
        if ((fecha.getMonthValue() == 1 || fecha.getMonthValue() == 7) && fecha.getDayOfMonth() > 15) {
            valor = valor + valor * 0.08;
        }

        // redondear a pesos
        valor = Math.round(valor);

        // registrar la matrícula (formato: documento;nombre;email;tipo;creditos;valor)
        String registro = documento + ";" + nombre + ";" + email + ";" + tipo + ";" + creditos + ";" + valor;
        registros.add(registro);

        // notificar al estudiante
        System.out.println("Enviando correo a " + email + ": su matrícula quedó en $" + valor);

        return valor;
    }

    public List<String> getRegistros() {
        return registros;
    }
}
