package co.edu.ingsoft.caso5;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase principal de facturación electrónica.
 * Hace todo lo relacionado con facturas.
 */
public class FacturaManager {

    private final Map<String, String> tablaFacturas = new HashMap<>(); // simula la tabla FACTURAS
    private int consecutivo = 1000;

    // =========================== CÁLCULOS TRIBUTARIOS ===========================

    // calcula el IVA: canasta básica exenta, medicamentos 5 %, el resto 19 %
    public double calcularIva(double subtotal, String tipoProducto) {
        if (tipoProducto.equals("CANASTA")) return 0;
        if (tipoProducto.equals("MEDICAMENTO")) return subtotal * 0.05;
        return subtotal * 0.19;
    }

    // calcula la retención: 2.5 % si el cliente es gran contribuyente y supera la base mínima
    public double calcularRetencion(double subtotal, boolean granContribuyente) {
        if (granContribuyente && subtotal > 1310000) return subtotal * 0.025;
        return 0;
    }

    // ================================ FACTURA ===================================

    public String crearFactura(String nitCliente, String nombreCliente, String emailCliente,
                               double subtotal, String tipoProducto, boolean granContribuyente) {
        double iva = calcularIva(subtotal, tipoProducto);
        double retencion = calcularRetencion(subtotal, granContribuyente);
        double total = subtotal + iva - retencion;
        String numero = "FE-" + (consecutivo++);

        guardar(numero, nitCliente, nombreCliente, subtotal, iva, retencion, total);
        String xml = generarXmlDian(numero, nitCliente, subtotal, iva, retencion, total);
        enviarDian(xml);
        byte[] pdf = generarPdf(numero, nombreCliente, subtotal, iva, retencion, total);
        enviarCorreo(emailCliente, numero, pdf);
        return numero;
    }

    // ============================== PERSISTENCIA ================================

    // guarda la factura en la base de datos y actualiza el consecutivo
    private void guardar(String numero, String nit, String nombre,
                         double subtotal, double iva, double retencion, double total) {
        String sql = "INSERT INTO facturas VALUES ('" + numero + "','" + nit + "','" + nombre + "',"
                + subtotal + "," + iva + "," + retencion + "," + total + ")";
        System.out.println("[BD] " + sql);
        tablaFacturas.put(numero, nit + "|" + nombre + "|" + subtotal + "|" + iva + "|" + retencion + "|" + total);
    }

    public String buscar(String numero) {
        return tablaFacturas.get(numero);
    }

    // ================================== DIAN ====================================

    // arma el XML que exige la DIAN (formato simplificado)
    private String generarXmlDian(String numero, String nit, double subtotal,
                                  double iva, double retencion, double total) {
        return "<Invoice><ID>" + numero + "</ID><IssueDate>" + LocalDateTime.now() + "</IssueDate>"
                + "<CustomerNIT>" + nit + "</CustomerNIT><LineExtension>" + subtotal + "</LineExtension>"
                + "<TaxIVA>" + iva + "</TaxIVA><Withholding>" + retencion + "</Withholding>"
                + "<Payable>" + total + "</Payable></Invoice>";
    }

    // envía a la DIAN. TODO: manejar reintentos cuando el servicio no responde
    private void enviarDian(String xml) {
        System.out.println("[DIAN] POST https://api.dian.example/facturas " + xml.length() + " bytes");
    }

    // =================================== PDF ====================================

    // genera la representación gráfica (por ahora texto plano)
    private byte[] generarPdf(String numero, String nombre, double subtotal,
                              double iva, double retencion, double total) {
        String contenido = "FACTURA ELECTRÓNICA " + numero + "\nCliente: " + nombre
                + "\nSubtotal: $" + subtotal + "\nIVA: $" + iva + "\nRetención: $" + retencion
                + "\nTOTAL: $" + total;
        return contenido.getBytes(StandardCharsets.UTF_8);
    }

    // ================================= CORREO ===================================

    // envía la factura por correo electrónico al cliente
    private void enviarCorreo(String email, String numero, byte[] adjunto) {
        System.out.println("[SMTP] Para: " + email + " | Asunto: Factura " + numero
                + " | Adjunto: " + adjunto.length + " bytes");
    }
}
