package org.example.Service;

import org.example.Model.Estudiante;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class EstudianteServiceImpl implements EstudianteService {

    private List<Estudiante> estudiantes = new ArrayList<>();
    private Long contadorId = 1L; // Genera ID automático

    @Override
    public Estudiante registrarEstudiante(String nombre, String correo, String programa) {

        validarCampos(nombre, correo, programa);
        validarCorreo(correo);

        Estudiante estudiante = new Estudiante(contadorId++, nombre, correo, programa);
        estudiantes.add(estudiante);

        return estudiante;
    }

    @Override
    public List<Estudiante> listarEstudiantes() {
        return estudiantes;
    }

    @Override
    public Estudiante buscarPorId(Long id) {

        for (Estudiante e : estudiantes) {
            if (e.getId().equals(id)) {
                return e;
            }
        }

        return null;
    }

    @Override
    public void modificarEstudiante(Long id, String nombre, String correo, String programa) {

        Estudiante estudiante = buscarPorId(id);

        if (estudiante == null) {
            throw new IllegalArgumentException("Estudiante no encontrado");
        }

        validarCampos(nombre, correo, programa);
        validarCorreo(correo);

        estudiante.setNombre(nombre);
        estudiante.setCorreo(correo);
        estudiante.setPrograma(programa);
    }

    @Override
    public void eliminarEstudiante(Long id) {

        Estudiante estudiante = buscarPorId(id);

        if (estudiante == null) {
            throw new IllegalArgumentException("Estudiante no encontrado");
        }

        estudiantes.remove(estudiante);
    }

    // Valida campos vacíos
    private void validarCampos(String nombre, String correo, String programa) {

        if (nombre == null || nombre.isBlank() ||
                correo == null || correo.isBlank() ||
                programa == null || programa.isBlank()) {

            throw new IllegalArgumentException("No se permiten campos vacíos");
        }
    }

    // Valida formato de correo; se crea un patrón (regex) para comprobar que el correo tenga un formato válido y verifica si el correo coincide
    private void validarCorreo(String correo) {

        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";    // Expresión regular que define el formato válido
        Pattern pattern = Pattern.compile(regex);   // Convierte la expresión en un patrón que Java puede usar

        if (!pattern.matcher(correo).matches()) {    // Compara el correo ingresado con el patrón
            throw new IllegalArgumentException("Correo inválido");
        }
    }
}
