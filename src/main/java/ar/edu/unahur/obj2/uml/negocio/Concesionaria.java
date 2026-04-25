package ar.edu.unahur.obj2.uml.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unahur.obj2.uml.usuarios.Usuario;
import ar.edu.unahur.obj2.uml.veiculos.Veiculo;

public class Concesionaria {
  private static Concesionaria instancia;

  private List<Veiculo> veiculos = new ArrayList<>();
  private List<Alquiler> alquileres = new ArrayList<>();

  private Concesionaria() {}

  public static Concesionaria getInstancia() {
    if (instancia == null) {
      instancia = new Concesionaria();
    }
    return instancia;
  }

  public void agregarVeiculo(Veiculo veiculo) {
    veiculos.add(veiculo);
  }

  public List<Veiculo> getVeiculosDisponibles() {
    return veiculos.stream()
      .filter(v -> !v.getEstaAlquilado())
      .collect(Collectors.toList());
  }

  public Alquiler alquilar(Usuario usuario, Veiculo veiculo) {
    Alquiler alquiler = new Alquiler(usuario, veiculo);
    usuario.alquilarVeiculo(alquiler);
    alquileres.add(alquiler);
    return alquiler;
  }
}
