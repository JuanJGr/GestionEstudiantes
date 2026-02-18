package org.example.Model;

public class Estudiante {

    private Long id;
    private String nombre;
    private String correo;
    private String programa;

    // Constructor vacio

    public Estudiante() {
    }

    // Constructor completo
    public Estudiante(Long id, String nombre, String correo, String programa) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.programa = programa;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    // Generar el toString

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", programa='" + programa + '\'' +
                '}';
    }
}
