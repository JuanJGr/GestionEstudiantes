package org.example.Service;

import org.example.Model.Estudiante;
import java.util.List;

public interface EstudianteService {

    Estudiante registrarEstudiante(String nombre, String correo, String programa);

    List<Estudiante> listarEstudiantes();

    Estudiante buscarPorId(Long id);

    void modificarEstudiante(Long id, String nombre, String correo, String programa);

    void eliminarEstudiante(Long id);
}
