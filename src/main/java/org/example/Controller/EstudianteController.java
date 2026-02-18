package org.example.Controller;

import org.example.Model.Estudiante;
import org.example.Service.EstudianteService;
import org.example.View.EstudianteView;

import java.util.List;

public class EstudianteController {

    private final EstudianteService service;
    private final EstudianteView view;

    public EstudianteController(EstudianteService service, EstudianteView view) {
        this.service = service;
        this.view = view;
    }

    // POST
    public void registrar(String nombre, String correo, String programa) {
        Estudiante estudiante = service.registrarEstudiante(nombre, correo, programa);
        view.mostrarMensaje("Estudiante registrado con ID: " + estudiante.getId());
    }

    // GET
    public void listar() {
        List<Estudiante> lista = service.listarEstudiantes();
        view.mostrarLista(lista);
    }

    // GET
    public void buscar(Long id) {
        Estudiante estudiante = service.buscarPorId(id);

        if (estudiante == null) {
            view.mostrarMensaje("Estudiante no encontrado");
        } else {
            view.mostrarEstudiante(estudiante);
        }
    }

    // PUT
    public void modificar(Long id, String nombre, String correo, String programa) {
        service.modificarEstudiante(id, nombre, correo, programa);
        view.mostrarMensaje("Estudiante modificado correctamente");
    }

    // DELETE
    public void eliminar(Long id) {
        service.eliminarEstudiante(id);
        view.mostrarMensaje("Estudiante eliminado correctamente");
    }
}
