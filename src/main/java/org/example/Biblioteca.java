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
          personas.put(nif,new Usuario(nif,nombre));
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
    public void prestarLibro(Usuario u, Libro l) {
        if (u.anadirLibro(l))
            l.restarEjemplaresDisponibles();
    }
    public boolean devolverLibro(Usuario u, Libro l) {
        if (u.tieneLibro(l))
            if (u.eliminarLibro(l))
                l.sumarEjemplar();
        else return false;
        return true;
    }

    public List<Usuario> usuariosConLibro(Libro l) {
        List<Usuario> lista=new ArrayList<>();
        for (Persona p:personas.values())
            if (p instanceof Usuario)
                if(((Usuario)p).tieneLibro(l))
                    lista.add((Usuario)p);
        return lista;
    }
    public void borrarUsuario(Usuario u) {
        personas.remove(u.nif);
    }
}
