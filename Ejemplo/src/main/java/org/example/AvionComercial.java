package org.example;

public class AvionComercial extends Avion {
    public AvionComercial(int capacidadCombustible, int consumoCombustible) {
        super(capacidadCombustible, consumoCombustible);
    }

    public int volar(int distancia) {
        int combustibleNecesario = distancia * getConsumoCombustible();

        return combustibleNecesario;
    }
}
