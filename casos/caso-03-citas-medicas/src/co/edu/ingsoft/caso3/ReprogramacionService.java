package co.edu.ingsoft.caso3;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReprogramacionService {

    // Mueve una cita a otro horario (lo usa el call center)
    public void reprogramar(Cita cita, LocalDate nuevaFecha, LocalTime nuevaHoraInicio, LocalTime nuevaHoraFin) {
        cita.setFecha(nuevaFecha);
        cita.setHoraInicio(nuevaHoraInicio);
        cita.setHoraFin(nuevaHoraFin);
        cita.setEstado("PROGRAMADA");
    }
}
