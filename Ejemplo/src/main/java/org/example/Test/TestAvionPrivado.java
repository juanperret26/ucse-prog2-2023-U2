package org.example.Test;

import org.example.Avion;
import org.example.AvionPrivado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAvionPrivado {
    private AvionPrivado avionPrivado = new AvionPrivado(777, 20);
    int distancia = 50 ;
    @Test
    public  void volarTest()
    {
        Assertions.assertEquals(1388,avionPrivado.volar(50));

    }
    @Test
    public void testGetCapacidadCombustible() {

        Assertions.assertEquals(777, avionPrivado.getCapacidadCombustible());
    }

    @Test
    public void testGetConsumoCombustible() {

        Assertions.assertEquals(20, avionPrivado.getConsumoCombustible());
    }

}
