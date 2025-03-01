package org.iesalandalus.programacion.cuatroenraya.modelo;

public record Jugador(String nombre, Ficha colorFicha) {

    public Jugador {
        validarNombre(nombre);
        validarColorFichas(colorFicha);
    }

    private void validarNombre(String nombre) {
        if (nombre == null) {
            throw new NullPointerException("El nombre no puede ser nulo.");
        }
        if (nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar en blanco.");
        }
    }

    private void validarColorFichas(Ficha colorFicha) {
        if (colorFicha == null) {
            throw new NullPointerException("El color de las fichas no puede ser nulo.");
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", nombre, colorFicha.toString());
    }
}