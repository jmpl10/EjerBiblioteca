package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Libro {
    int signatura;
    String titulo;
    int numEjemplares;
    static int NUMLIBROS=0;
    Libro(String titulo, int numEjemplares) {
        this.titulo = titulo;
        this.numEjemplares = numEjemplares;
        signatura=++NUMLIBROS;
    }

}
