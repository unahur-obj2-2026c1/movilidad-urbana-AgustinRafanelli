package ar.edu.unahur.obj2.uml.usuarios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.uml.negocio.Alquiler;

public class Usuario {
  private String nombre;
  private List<Alquiler> registroDeAlquileres = new ArrayList<>();

  public Usuario(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public List<Alquiler> getRegistroDeAlquileres() {
    return registroDeAlquileres;
  }

  public void alquilarVeiculo(Alquiler alquiler) {
    registroDeAlquileres.add(alquiler);
  }
}
