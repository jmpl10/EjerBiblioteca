package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private Map<String, Persona> personas;

    Biblioteca(){
        libros=new ArrayList<>();
        personas=new HashMap<>();
    }

    public void anadirLibro(Libro l) {
        libros.add(l);
    }
    public List<Libro> todosLosLibros() {
        return libros;
    }
    public void altaUsuario(String nif, String nombre) {
        if (!personas.containsKey(nif))
          personas.put(nif,new Persona(nif,nombre));

    }
}
