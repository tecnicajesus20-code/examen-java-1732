package com.carmotors.servicio.observer;

import com.carmotors.modelo.EventoServicioCompletado;

public interface Sujeto {
    void notificarObservadores(EventoServicioCompletado evento);
    void registrarObservador(Observador observador);

}
