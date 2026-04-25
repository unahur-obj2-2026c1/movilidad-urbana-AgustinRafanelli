package ar.edu.unahur.obj2.uml.negocio;

import java.util.Date;

import ar.edu.unahur.obj2.uml.usuarios.Usuario;
import ar.edu.unahur.obj2.uml.veiculos.Veiculo;

public class Alquiler {
  private Usuario usuario;
  private Veiculo veiculo;
  private Date fechaInicioAlquiler;
  private Date fechaFinAlquiler;

  public Alquiler(Usuario usuario, Veiculo veiculo) {
    if (veiculo.getEstaAlquilado()) {
      throw new RuntimeException("El vehículo ya está alquilado");
    }
    veiculo.alquilar();
    this.usuario = usuario;
    this.veiculo = veiculo;
    this.fechaInicioAlquiler = new Date();
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public Veiculo getVeiculo() {
    return veiculo;
  }

  public Date getFechaInicioAlquiler() {
    return fechaInicioAlquiler;
  }

  public Date getFechaFinAlquiler() {
    return fechaFinAlquiler;
  }

  public void finalizarAlquiler() {
    this.fechaFinAlquiler = new Date();
    veiculo.devolver();
  }
}
