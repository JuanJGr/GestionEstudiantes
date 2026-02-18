package org.example.View;

import org.example.Model.Estudiante;

import java.util.List;
import java.util.Scanner;

public class EstudianteView {

    private Scanner scanner = new Scanner(System.in);

    // Muestra menú principal
    public int mostrarMenu() {
        System.out.println("\n----- SISTEMA DE ESTUDIANTES -----");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Listar estudiantes");
        System.out.println("3. Buscar estudiante");
        System.out.println("4. Modificar estudiante");
        System.out.println("5. Eliminar estudiante");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");

        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }

    // Solicita nombre con validación
    public String pedirNombre() {

        while (true) {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            if (!nombre.isBlank()) {
                return nombre;
            } else {
                System.out.println("El nombre no puede estar vacío.");
            }
        }
    }

    // Solicita correo con validación inmediata
    public String pedirCorreo() {

        while (true) {
            System.out.print("Correo: ");
            String correo = scanner.nextLine();

            if (correo.isBlank()) {
                System.out.println("El correo no puede estar vacío.");
                continue;
            }

            if (correo.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                return correo;
            } else {
                System.out.println("Correo inválido. Intente nuevamente.");
            }
        }
    }

    // Solicita programa con validación
    public String pedirPrograma() {

        while (true) {
            System.out.print("Programa académico: ");
            String programa = scanner.nextLine();

            if (!programa.isBlank()) {
                return programa;
            } else {
                System.out.println("El programa no puede estar vacío.");
            }
        }
    }

    // Solicita ID con validación
    public Long pedirId() {

        while (true) {
            System.out.print("ID del estudiante: ");

            try {
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un ID numérico válido.");
            }
        }
    }

    // Muestra un estudiante
    public void mostrarEstudiante(Estudiante estudiante) {
        System.out.println("-----------");
        System.out.println("ID: " + estudiante.getId());
        System.out.println("Nombre: " + estudiante.getNombre());
        System.out.println("Correo: " + estudiante.getCorreo());
        System.out.println("Programa: " + estudiante.getPrograma());
    }

    // Muestra lista de estudiantes
    public void mostrarLista(List<Estudiante> estudiantes) {

        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados");
            return;
        }

        for (Estudiante e : estudiantes) {
            mostrarEstudiante(e);
        }
    }

    // Muestra mensaje general
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
