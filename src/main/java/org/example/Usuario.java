package org.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona{
    List<Libro> prestados;
    Usuario (String nif, String nombre){
        super(nif, nombre);
        prestados=new ArrayList<>();
    }

}
