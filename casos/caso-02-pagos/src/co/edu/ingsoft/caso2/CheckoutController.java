package co.edu.ingsoft.caso2;

public class CheckoutController {

    private final ProcesadorPagos procesador = new ProcesadorPagos();
    private final ReportePagos reporte = new ReportePagos();

    public String pagarConTarjeta(double monto, String moneda,
                                  String numeroTarjeta, String fechaExpiracion, String cvv) {
        String ref = procesador.procesar("TARJETA", monto, moneda, numeroTarjeta, fechaExpiracion, cvv, null, null);
        return reporte.lineaReporte("TARJETA", monto, moneda, ref);
    }

    public String pagarConPse(double monto, String moneda, String banco) {
        String ref = procesador.procesar("PSE", monto, moneda, null, null, null, banco, null);
        return reporte.lineaReporte("PSE", monto, moneda, ref);
    }

    public String pagarConNequi(double monto, String moneda, String celular) {
        String ref = procesador.procesar("NEQUI", monto, moneda, null, null, null, null, celular);
        return reporte.lineaReporte("NEQUI", monto, moneda, ref);
    }

    // Valida que el medio elegido en el formulario esté habilitado
    public boolean medioHabilitado(String medioPago) {
        return medioPago.equals("TARJETA") || medioPago.equals("PSE") || medioPago.equals("NEQUI");
    }
}
