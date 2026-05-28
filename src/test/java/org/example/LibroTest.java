package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibroTest {

    @Test
    void restarEjemplaresDisponibles() {
        Libro l=new Libro("Quijote",0);
        l.restarEjemplaresDisponibles();
        int res=l.getNumEjemplares();
        assertEquals(res,0);
    }

    @Test
    void sumarEjemplar() {
    }
}