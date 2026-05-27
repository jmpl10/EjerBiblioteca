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
    public List<Usuario> listarUsuarios() {
        List<Usuario> listaUsuarios=new ArrayList<>();
        for (Persona p:personas.values()){
            if (p instanceof Usuario)
                listaUsuarios.add((Usuario)p);
        }
        return listaUsuarios;
    }
    public Usuario getUsuario(String nif) {
        Persona p= personas.get(nif);
        if (p!=null && p instanceof Usuario)
          return (Usuario)p;
        return null;

    }

    public Libro getLibro(int signatura) {
        Libro laux=null;
        for (Libro l:libros)
            if (l.getSignatura()==signatura) {
                laux = l;
                break;
            }
        return laux;
    }
}
