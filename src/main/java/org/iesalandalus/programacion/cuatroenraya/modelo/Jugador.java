package org.iesalandalus.programacion.cuatroenraya.modelo;

public record Jugador(String nombre, Ficha colorFichas) {

    public Jugardor{
        validarNombre(nombre);
        validarColorFichas(colorFichas);
    }

    private void validarNombre(String nombre){
        if(nombre == null){
            throw new NullPointerException("El nombre no puede ser nulo.");
        }

        if(nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no se puede quedar en blanco.");
        }

    }

    private void validarColorFichas(Ficha colorFichas){

    }


}