package ar.edu.unahur.obj2.uml.negocio;

import ar.edu.unahur.obj2.uml.usuarios.Usuario;
import ar.edu.unahur.obj2.uml.veiculos.Bicicleta;
import ar.edu.unahur.obj2.uml.veiculos.Monopatin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

public class ConcesionariaTest {

    @BeforeEach
    void resetSingleton() throws Exception {
        Field campo = Concesionaria.class.getDeclaredField("instancia");
        campo.setAccessible(true);
        campo.set(null, null);
    }

    @Test
    void getInstanciaRetornaSiempreLaMismaInstancia() {
        assertSame(Concesionaria.getInstancia(), Concesionaria.getInstancia());
    }

    @Test
    void veiculosDisponiblesIniciaVacio() {
        assertTrue(Concesionaria.getInstancia().getVeiculosDisponibles().isEmpty());
    }

    @Test
    void agregarVeiculoLoHaceDisponible() {
        Concesionaria c = Concesionaria.getInstancia();
        c.agregarVeiculo(new Bicicleta(26));
        assertEquals(1, c.getVeiculosDisponibles().size());
    }

    @Test
    void alquilarReduceVeiculosDisponibles() {
        Concesionaria c = Concesionaria.getInstancia();
        Bicicleta b = new Bicicleta(26);
        c.agregarVeiculo(b);
        c.alquilar(new Usuario("Pedro"), b);
        assertTrue(c.getVeiculosDisponibles().isEmpty());
    }

    @Test
    void alquilarRegistraAlquilerEnElUsuario() {
        Concesionaria c = Concesionaria.getInstancia();
        Bicicleta b = new Bicicleta(26);
        c.agregarVeiculo(b);
        Usuario u = new Usuario("Pedro");
        c.alquilar(u, b);
        assertEquals(1, u.getRegistroDeAlquileres().size());
    }

    @Test
    void soloMuestraVeiculosNoAlquilados() {
        Concesionaria c = Concesionaria.getInstancia();
        Bicicleta b1 = new Bicicleta(26);
        Monopatin m = new Monopatin("Xiaomi");
        c.agregarVeiculo(b1);
        c.agregarVeiculo(m);
        c.alquilar(new Usuario("Laura"), b1);
        assertEquals(1, c.getVeiculosDisponibles().size());
        assertTrue(c.getVeiculosDisponibles().contains(m));
    }

    @Test
    void finalizarAlquilerDevuelveVeiculoADisponibles() {
        Concesionaria c = Concesionaria.getInstancia();
        Bicicleta b = new Bicicleta(26);
        c.agregarVeiculo(b);
        Alquiler alquiler = c.alquilar(new Usuario("Carlos"), b);
        alquiler.finalizarAlquiler();
        assertEquals(1, c.getVeiculosDisponibles().size());
    }

    @Test
    void alquilarRetornaAlquilerValido() {
        Concesionaria c = Concesionaria.getInstancia();
        Bicicleta b = new Bicicleta(26);
        c.agregarVeiculo(b);
        Usuario u = new Usuario("Maria");
        Alquiler alquiler = c.alquilar(u, b);
        assertNotNull(alquiler);
        assertEquals(u, alquiler.getUsuario());
        assertEquals(b, alquiler.getVeiculo());
    }
}
