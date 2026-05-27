package org.example;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void menu(Biblioteca b) {
        Scanner sc = new Scanner(System.in);
        int opc=0;
        System.out.println("Biblioteca Principal");
        do {
            System.out.println("1-Dar alta libro");
            System.out.println("2-Dar alta usuario");
            System.out.println("3-Listar libros");
            System.out.println("4-Listar usuarios");
            System.out.println("5-Prestar Libro");
            System.out.println("0-fin" );
            try {
                opc = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Debe introducir un NÚMERO de opción");
            }
            switch (opc) {
                case 1-> altaLibro(b);
                case 2-> altaUsuario(b);
                case 3-> listarLibros(b);
                case 4-> listarUsuarios(b);
                case 0-> System.out.println("Fin");
                default -> System.out.println("Error. Opción no válida");
            }
        }while (opc!=0);
    }

    private static void listarUsuarios(Biblioteca b) {
        List<Usuario> listaUsuarios= b.listarUsuarios();
        for (Usuario u:listaUsuarios){
            System.out.println(u);
        }
    }

    private static void altaUsuario(Biblioteca b) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nif:");
        String nif = sc.nextLine();
        System.out.println("Nombre");
        String nombre = sc.nextLine();
        b.altaUsuario(nif,nombre);

    }

    private static void listarLibros(Biblioteca b) {
        List<Libro> listaLibros= b.todosLosLibros();
        for (Libro l:listaLibros)
            System.out.println(l);
    }

    private static void altaLibro(Biblioteca b) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Título");
        String titulo = sc.nextLine();
        System.out.println("Num Ejemplares");
        int numEjemplares = sc.nextInt();
        Libro l= new Libro(titulo, numEjemplares);
        b.anadirLibro(l);

    }

    public static void main(String[] args) {
            Biblioteca b=new Biblioteca();
            menu(b);

    }
}