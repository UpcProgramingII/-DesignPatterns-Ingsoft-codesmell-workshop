package co.edu.ingsoft.caso3;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class AgendaService {

    private final List<Cita> citas = new ArrayList<>();
    private long secuencia = 1;

    public Cita agendar(Paciente paciente, String medico, LocalDate fecha,
                        LocalTime horaInicio, LocalTime horaFin) {
        if (paciente.getInasistencias() >= 3) {
            throw new IllegalStateException("Paciente bloqueado por inasistencias");
        }
        if (!horaInicio.isBefore(horaFin)) {
            throw new IllegalArgumentException("Horario inválido");
        }
        for (Cita c : citas) {
            if (c.getMedico().equals(medico) && c.getFecha().equals(fecha)
                    && !c.getEstado().equals("CANCELADA")
                    && horaInicio.isBefore(c.getHoraFin()) && c.getHoraInicio().isBefore(horaFin)) {
                throw new IllegalStateException("El médico ya tiene una cita en ese horario");
            }
        }
        Cita cita = new Cita();
        cita.setId(secuencia++);
        cita.setPaciente(paciente);
        cita.setMedico(medico);
        cita.setFecha(fecha);
        cita.setHoraInicio(horaInicio);
        cita.setHoraFin(horaFin);
        cita.setEstado("PROGRAMADA");
        citas.add(cita);
        return cita;
    }

    public void cancelar(Cita cita, LocalDateTime ahora) {
        if (cita.getEstado().equals("ATENDIDA")) {
            throw new IllegalStateException("No se puede cancelar una cita atendida");
        }
        LocalDateTime inicio = LocalDateTime.of(cita.getFecha(), cita.getHoraInicio());
        if (Duration.between(ahora, inicio).toHours() < 24) {
            Paciente p = cita.getPaciente();
            p.setInasistencias(p.getInasistencias() + 1);
        }
        cita.setEstado("CANCELADA");
    }

    public boolean esPrioritario(Paciente paciente) {
        int edad = Period.between(paciente.getFechaNacimiento(), LocalDate.now()).getYears();
        return edad >= 60 || edad < 5;
    }

    public long duracionEnMinutos(Cita cita) {
        return Duration.between(cita.getHoraInicio(), cita.getHoraFin()).toMinutes();
    }

    public List<Cita> citasDelDia(String medico, LocalDate fecha) {
        List<Cita> resultado = new ArrayList<>();
        for (Cita c : citas) {
            if (c.getMedico().equals(medico) && c.getFecha().equals(fecha)
                    && c.getEstado().equals("PROGRAMADA")) {
                resultado.add(c);
            }
        }
        return resultado;
    }
}
