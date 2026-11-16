package co.edu.ingsoft.caso2;

public class ReportePagos {

    private final ProcesadorPagos procesador = new ProcesadorPagos();

    public String etiqueta(String medioPago) {
        if (medioPago.equals("TARJETA")) {
            return "Tarjeta de crédito";
        } else if (medioPago.equals("PSE")) {
            return "Débito bancario PSE";
        } else if (medioPago.equals("NEQUI")) {
            return "Billetera Nequi";
        }
        return "Otro";
    }

    public String lineaReporte(String medioPago, double monto, String moneda, String referencia) {
        double comision = procesador.calcularComision(medioPago, monto);
        double neto = monto - comision;
        return String.format("%s | %s | %.2f %s | comisión %.2f %s | neto %.2f %s | acredita en %d días",
                referencia, etiqueta(medioPago), monto, moneda, comision, moneda, neto, moneda,
                procesador.diasParaAcreditar(medioPago));
    }
}
