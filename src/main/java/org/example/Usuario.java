package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Usuario extends Persona{
    List<Libro> prestados;
    Usuario (String nif, String nombre){
        super(nif, nombre);
        prestados=new ArrayList<>();
    }
    @Override
    public String toString(){
        String aux=nif+","+nombre;
        for(Libro l:prestados)
            aux+=","+l.getTitulo();
        return aux;
    }
    public boolean anadirLibro(Libro l) {
        prestados.add(l);
        return true;
    }
    public boolean tieneLibro(Libro l) {
        if (prestados.contains(l))
            return true;
        return false;
    }

    public boolean eliminarLibro(Libro l) {
        boolean encontrado=false;
        for (int i=0; i<prestados.size() && !encontrado;i++) {
            if( l.getSignatura()==prestados.get(i).getSignatura()) {
                prestados.remove(i);
                encontrado = true;
            }
        }
       // prestados.remove(l);
        return true;
    }
}
