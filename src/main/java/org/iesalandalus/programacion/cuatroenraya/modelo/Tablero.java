package org.iesalandalus.programacion.cuatroenraya.modelo;

public class Tablero {
    public static int FILAS = 6;
    public static int COLUMNAS = 7;
    public static int FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS = 4;
    Casilla casilla[][];

    public Tablero(){
        casilla = new Casilla[FILAS][COLUMNAS];
        for(int i = 0; i < FILAS; i++){
            for(int j  = 0; j < COLUMNAS; j++){
                casilla[i][j] = new Casilla();
            }
        }
    }

    private boolean columnaVacia(int columna){
        for(int i = 0; i < FILAS; i++){
            if(casilla[i][columna] != null){
                return false;
            }
        }

        return true;
    }

    public boolean estaVacio(){
        for(int j = 0; j < COLUMNAS; j++){
            if(!columnaVacia(j)){
                return false;
            }
        }

        return true;
    }

    private boolean columnaLlena(int columna){
        for(int i = 0; i < FILAS; i++){
            if(casilla[i][columna] == null){
                return false;
            }
        }
        return true;
    }

    public boolean estaLleno(){
        for(int j = 0; j < COLUMNAS; j++){
            if(!columnaLlena(j)){
                return false;
            }
        }
        return true;
    }

    private void comprobarFicha(Ficha ficha){
        if(ficha == null){
            throw new NullPointerException("La ficha no puede ser nula.");
        }
    }

    private void comprobarColumna(int columna){
        if(columna < 0 || columna >= COLUMNAS){
            throw new IllegalArgumentException("La columna se sale del tablero.");
        }
    }

    private int getPrimeraFilaVacia(int columna){
        comprobarColumna(columna);
        for(int i = 0; i < FILAS; i++){
            if(casilla[i][columna] == null){
                return i;
            }
        }
        throw new IllegalArgumentException("La columna está llena.");
    }

    private boolean objetivoAlcanzado(int fichasConsecutivas){
        return fichasConsecutivas >= FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS;
    }

    private boolean comprobarHorizontal(int fila, Ficha ficha){
        comprobarFicha(ficha);
        if(fila < 0 || fila >= FILAS){
            throw new IllegalArgumentException("La fila se sale del tablero.");
        }

        int fichasConsecutivas = 0;
        for(int columna = 0; columna < COLUMNAS; columna++){
            if(casilla[fila][columna] != null && casilla[fila][columna].getFicha() == ficha){
                fichasConsecutivas++;
                if(objetivoAlcanzado(fichasConsecutivas)){
                    return  true;
                }
            } else {
                fichasConsecutivas = 0;
            }
        }

        return false;
    }

    public boolean comprobarVertical(int columna, Ficha ficha) {
        comprobarFicha(ficha);
        comprobarColumna(columna);

        int fichasConsecutivas = 0;
        for (int fila = 0; fila < FILAS; fila++) {
            if (casilla[fila][columna] != null && casilla[fila][columna].getFicha() == ficha) {
                fichasConsecutivas++;
                if (objetivoAlcanzado(fichasConsecutivas)) {
                    return true;
                }
            } else {
                fichasConsecutivas = 0;
            }
        }
        return false;
    }

    public int menor(int a, int b) {
        return (a < b) ? a : b;
    }

    public boolean comprobarDiagonalNE(int filaActual, int columnaActual, Ficha ficha){

    }
}
























