package com.carmotors.servicio.observer;

import com.carmotors.modelo.EventoServicioCompletado;
import java.util.Objects;

public final class ObservadorLogServicio implements Observador {
    @Override
    public void actualizar(EventoServicioCompletado evento) {
        Objects.requireNonNull(evento);
        System.out.println("[LOG]: El servicio # " + evento.servicioId()
                + " para el vehículo " + evento.placa() + " ha sido completado.");
    }
}
