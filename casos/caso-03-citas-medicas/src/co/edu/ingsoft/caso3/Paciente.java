package co.edu.ingsoft.caso3;

import java.time.LocalDate;

public class Paciente {

    private String documento;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String eps;
    private int inasistencias;

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public String getEps() { return eps; }
    public void setEps(String eps) { this.eps = eps; }
    public int getInasistencias() { return inasistencias; }
    public void setInasistencias(int inasistencias) { this.inasistencias = inasistencias; }
}
