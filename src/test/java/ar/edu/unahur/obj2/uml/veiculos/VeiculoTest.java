package ar.edu.unahur.obj2.uml.veiculos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VeiculoTest {

    @Test
    void bicicletaIniciaNoAlquilada() {
        Bicicleta b = new Bicicleta(26);
        assertFalse(b.getEstaAlquilado());
    }

    @Test
    void alquilarMarcaComoAlquilado() {
        Bicicleta b = new Bicicleta(26);
        b.alquilar();
        assertTrue(b.getEstaAlquilado());
    }

    @Test
    void devolverMarcaComoDisponible() {
        Bicicleta b = new Bicicleta(26);
        b.alquilar();
        b.devolver();
        assertFalse(b.getEstaAlquilado());
    }

    @Test
    void bicicletaGuardaRodado() {
        Bicicleta b = new Bicicleta(29);
        assertEquals(29, b.getRodado());
    }

    @Test
    void monopatinIniciaNoAlquilado() {
        Monopatin m = new Monopatin("Xiaomi");
        assertFalse(m.getEstaAlquilado());
    }

    @Test
    void monopatinGuardaMarca() {
        Monopatin m = new Monopatin("Xiaomi");
        assertEquals("Xiaomi", m.getMarca());
    }
}
