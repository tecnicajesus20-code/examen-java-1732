package com.carmotors.servicio.observer;

import com.carmotors.modelo.EventoServicioCompletado;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public final class ObservadorNotificacionCliente implements Observador {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final Path archivo;

    public ObservadorNotificacionCliente() {
        this(Path.of("notificaciones_clientes.txt"));
    }

    public ObservadorNotificacionCliente(Path archivo) {
        this.archivo = Objects.requireNonNull(archivo, "La ruta del archivo es obligatoria.");
    }

    @Override
    public synchronized void actualizar(EventoServicioCompletado evento) {
        Objects.requireNonNull(evento);
        String linea = "[" + evento.fechaCompletado().format(FORMATO) + "] - NOTIFICACIÓN PARA "
                + unaLinea(evento.nombreCliente()) + ": Su vehículo con placa "
                + unaLinea(evento.placa()) + " está listo para ser recogido."
                + System.lineSeparator();
        try {
            Files.writeString(archivo, linea, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new UncheckedIOException("No se pudo guardar la notificación del cliente.", e);
        }
    }

    private String unaLinea(String valor) {
        return valor.replace('\r', ' ').replace('\n', ' ');
    }
}
