package org.example;

import org.example.Controller.EstudianteController;
import org.example.Service.EstudianteService;
import org.example.Service.EstudianteServiceImpl;
import org.example.View.EstudianteView;

public class Main {

    public static void main(String[] args) {

        EstudianteService service = new EstudianteServiceImpl();
        EstudianteView view = new EstudianteView();
        EstudianteController controller = new EstudianteController(service, view);

        boolean ejecutar = true;

        while (ejecutar) {

            try {

                int opcion = view.mostrarMenu();

                switch (opcion) {

                    case 1 -> {
                        // POST
                        controller.registrar(
                                view.pedirNombre(),
                                view.pedirCorreo(),
                                view.pedirPrograma()
                        );
                    }

                    case 2 -> {
                        // GET
                        controller.listar();
                    }

                    case 3 -> {
                        // GET
                        controller.buscar(view.pedirId());
                    }

                    case 4 -> {
                        // PUT
                        controller.modificar(
                                view.pedirId(),
                                view.pedirNombre(),
                                view.pedirCorreo(),
                                view.pedirPrograma()
                        );
                    }

                    case 5 -> {
                        // DELETE
                        controller.eliminar(view.pedirId());
                    }

                    case 6 -> {
                        ejecutar = false;
                        System.out.println("Saliendo del sistema...");
                    }

                    default -> System.out.println("Opción inválida");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
