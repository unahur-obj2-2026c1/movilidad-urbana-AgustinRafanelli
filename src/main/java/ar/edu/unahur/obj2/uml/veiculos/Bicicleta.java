package ar.edu.unahur.obj2.uml.veiculos;

public class Bicicleta extends Veiculo {
  private Integer rodado;
  
  public Bicicleta(Integer rodado) {
    this.rodado = rodado;
  }

  public Integer getRodado() {
    return rodado;
  }
}
