package ar.edu.unahur.obj2.uml.veiculos;

public abstract class Veiculo {
  private Boolean estaAlquilado = false;

  public void alquilar() {
    estaAlquilado = true;
  }
  
  public void devolver() {
    estaAlquilado = false;
  }

  public Boolean getEstaAlquilado() {
    return estaAlquilado;
  }
}
