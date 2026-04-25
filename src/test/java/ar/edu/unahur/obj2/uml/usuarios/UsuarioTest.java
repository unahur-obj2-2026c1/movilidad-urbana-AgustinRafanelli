package ar.edu.unahur.obj2.uml.usuarios;

import ar.edu.unahur.obj2.uml.negocio.Alquiler;
import ar.edu.unahur.obj2.uml.veiculos.Bicicleta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    void iniciaConRegistroVacio() {
        Usuario u = new Usuario("Ana");
        assertTrue(u.getRegistroDeAlquileres().isEmpty());
    }

    @Test
    void getNombreRetornaNombreCorrecto() {
        Usuario u = new Usuario("Ana");
        assertEquals("Ana", u.getNombre());
    }

    @Test
    void alquilarVeiculoAgregaAlRegistro() {
        Usuario u = new Usuario("Ana");
        Bicicleta b = new Bicicleta(26);
        Alquiler alquiler = new Alquiler(u, b);
        u.alquilarVeiculo(alquiler);
        assertEquals(1, u.getRegistroDeAlquileres().size());
    }

    @Test
    void registroContieneElAlquilerAgregado() {
        Usuario u = new Usuario("Ana");
        Bicicleta b = new Bicicleta(26);
        Alquiler alquiler = new Alquiler(u, b);
        u.alquilarVeiculo(alquiler);
        assertTrue(u.getRegistroDeAlquileres().contains(alquiler));
    }
}
