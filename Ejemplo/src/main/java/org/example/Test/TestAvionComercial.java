package org.example.Test;

import org.example.Avion;
import org.example.AvionComercial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAvionComercial {
    private AvionComercial avionComercial = new AvionComercial( 1000,60);
    int distancia = 200;
    @Test
    public void volarTest()
    {
        Assertions.assertEquals(12000, avionComercial.volar(200));
    }

    @Test
    public void testGetCapacidadCombustible() {

        Assertions.assertEquals(1000, avionComercial.getCapacidadCombustible());
    }

    @Test
    public void testGetConsumoCombustible() {

        Assertions.assertEquals(60, avionComercial.getConsumoCombustible());

    }
}
