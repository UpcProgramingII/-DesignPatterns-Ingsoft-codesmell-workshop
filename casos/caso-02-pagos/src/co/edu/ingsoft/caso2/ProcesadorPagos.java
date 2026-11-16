package co.edu.ingsoft.caso2;

public class ProcesadorPagos {

    public String procesar(String medioPago, double monto, String moneda,
                           String numeroTarjeta, String fechaExpiracion, String cvv,
                           String banco, String celular) {
        if (monto <= 0) {
            return "RECHAZADO";
        }
        switch (medioPago) {
            case "TARJETA":
                if (numeroTarjeta == null || numeroTarjeta.length() != 16) return "RECHAZADO";
                if (cvv == null || cvv.length() != 3) return "RECHAZADO";
                if (fechaExpiracion == null || !fechaExpiracion.matches("\\d{2}/\\d{2}")) return "RECHAZADO";
                return "APROBADO-TC-" + System.currentTimeMillis();
            case "PSE":
                if (banco == null || banco.isBlank()) return "RECHAZADO";
                return "PENDIENTE-PSE-" + System.currentTimeMillis();
            case "NEQUI":
                if (celular == null || !celular.startsWith("3") || celular.length() != 10) return "RECHAZADO";
                return "PENDIENTE-NEQUI-" + System.currentTimeMillis();
            default:
                throw new IllegalArgumentException("Medio no soportado: " + medioPago);
        }
    }

    public double calcularComision(String medioPago, double monto) {
        switch (medioPago) {
            case "TARJETA":
                return monto * 0.0299 + 900;
            case "PSE":
                return 3500;
            case "NEQUI":
                return monto * 0.015;
            default:
                return 0;
        }
    }

    public int diasParaAcreditar(String medioPago) {
        switch (medioPago) {
            case "TARJETA":
                return 2;
            case "PSE":
                return 1;
            case "NEQUI":
                return 0;
            default:
                return 5;
        }
    }
}
