package ar.edu.unahur.obj2.uml.negocio;

import ar.edu.unahur.obj2.uml.usuarios.Usuario;
import ar.edu.unahur.obj2.uml.veiculos.Bicicleta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlquilerTest {

    private Usuario usuario;
    private Bicicleta bicicleta;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Juan");
        bicicleta = new Bicicleta(26);
    }

    @Test
    void creaAlquilerConFechaInicio() {
        Alquiler alquiler = new Alquiler(usuario, bicicleta);
        assertNotNull(alquiler.getFechaInicioAlquiler());
    }

    @Test
    void crearAlquilerMarcaVeiculoComoAlquilado() {
        new Alquiler(usuario, bicicleta);
        assertTrue(bicicleta.getEstaAlquilado());
    }

    @Test
    void noPermiteAlquilarVeiculoYaAlquilado() {
        new Alquiler(usuario, bicicleta);
        assertThrows(RuntimeException.class, () -> new Alquiler(usuario, bicicleta));
    }

    @Test
    void finalizarAlquilerLiberaElVeiculo() {
        Alquiler alquiler = new Alquiler(usuario, bicicleta);
        alquiler.finalizarAlquiler();
        assertFalse(bicicleta.getEstaAlquilado());
    }

    @Test
    void finalizarAlquilerSetFechaFin() {
        Alquiler alquiler = new Alquiler(usuario, bicicleta);
        assertNull(alquiler.getFechaFinAlquiler());
        alquiler.finalizarAlquiler();
        assertNotNull(alquiler.getFechaFinAlquiler());
    }

    @Test
    void getUsuarioRetornaElUsuarioCorrecto() {
        Alquiler alquiler = new Alquiler(usuario, bicicleta);
        assertEquals(usuario, alquiler.getUsuario());
    }

    @Test
    void getVeiculoRetornaElVeiculoCorrecto() {
        Alquiler alquiler = new Alquiler(usuario, bicicleta);
        assertEquals(bicicleta, alquiler.getVeiculo());
    }
}
